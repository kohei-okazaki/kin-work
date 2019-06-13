package jp.co.kin.tool.build;

import java.util.StringJoiner;

import org.apache.poi.ss.formula.functions.T;
import org.seasar.doma.Dao;

import jp.co.kin.common.type.LineFeedType;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.FileUtil.FileExtension;
import jp.co.kin.db.config.DaoRepository;
import jp.co.kin.db.dao.BaseDao;
import jp.co.kin.tool.build.annotation.Build;
import jp.co.kin.tool.config.FileConfig;
import jp.co.kin.tool.excel.Excel;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.factory.FileFactory;
import jp.co.kin.tool.source.Field;
import jp.co.kin.tool.source.Import;
import jp.co.kin.tool.source.JavaSource;
import jp.co.kin.tool.source.Method;
import jp.co.kin.tool.type.AccessType;
import jp.co.kin.tool.type.ClassType;
import jp.co.kin.tool.type.ExecuteType;

public class DaoBuilder extends SourceBuilder {

	@SuppressWarnings("unchecked")
	@Build
	public void execute() {
		Excel excel = super.reader.read();
		excel.activeSheet("TABLE_LIST");

		try {
			for (String table : this.targetTableList) {
				JavaSource source = new JavaSource();
				setCommonInfo(source);
				for (Row row : excel.getRowList()) {
					if (isTargetTable(row, table)) {
						source.setClassName(toJavaFileName(getPhysicalName(row)) + "Dao");

						Class<T> entityClass = (Class<T>) Class
								.forName("jp.co.kin.db.entity." + toJavaFileName(getPhysicalName(row)));

						Field<T> field = new Field<T>(table, table, entityClass, null);
						// Delete文メソッドを作成
						Method<T> delete = new Method<T>(field, AccessType.PUBLIC) {

							@Override
							protected String getMethodName() {
								return "delete";
							}

							@Override
							public String toString() {
								final String TAB = "	";
								Class<?> clazz = BeanUtil.getParameterType(field.getClassType());
								return TAB + accessType.getValue() + " int " + getMethodName() + "("
										+ clazz.getSimpleName() + " entity)";
							}
						};

						// Update文メソッドを作成

						// Insert文メソッドを作成
					}
				}
				FileConfig fileConf = getFileConfig(ExecuteType.DAO);
				fileConf.setFileName(toJavaFileName(table) + "Dao" + FileExtension.JAVA.getValue());
				fileConf.setData(build(source));
				FileFactory.create(fileConf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setCommonInfo(JavaSource source) {
		source.setPackage(new jp.co.kin.tool.source.Package("jp.co.kin.db.dao"));
		source.setClassType(ClassType.INTERFACE);
		source.setAccessType(AccessType.PUBLIC);
		source.addImplInterface(BaseDao.class);
		source.addImport(new Import(BaseDao.class));
		source.addClassAnnotation(Dao.class);
		source.addImport(new Import(Dao.class));
		source.addClassAnnotation(DaoRepository.class);
		source.addImport(new Import(DaoRepository.class));
	}

	private String build(JavaSource source) {

		StringJoiner result = new StringJoiner(LineFeedType.CRLF.getValue() + LineFeedType.CRLF.getValue());

		// package情報
		result.add(buildPackage(source));

		// import情報
		result.add(buildImport(source.getImportList()));

		// class情報
		result.add(buildClassAnnotation(source.getClassAnnotationList(), null)
				+ LineFeedType.CRLF.getValue() + buildClass(source) + buildInterfaces(source) + " {");

		result.add("}");

		return result.toString();
	}

}
