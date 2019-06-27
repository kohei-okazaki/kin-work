package jp.co.kin.tool.build;

import java.util.Map.Entry;
import java.util.StringJoiner;

import org.apache.poi.ss.formula.functions.T;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;

import jp.co.kin.common.type.LineFeedType;
import jp.co.kin.common.util.FileUtil.FileExtension;
import jp.co.kin.common.util.StringUtil;
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
import jp.co.kin.tool.source.Signature;
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

				boolean isCreatedDeleteMethod = false;
				boolean isCreatedUpdateMethod = false;
				boolean isCreatedInsertMethod = false;
				for (Row row : excel.getRowList()) {

					if (!isTargetTable(row, table)) {
						continue;
					}
					source.setClassName(toJavaFileName(getPhysicalName(row)) + "Dao");

					Class<T> entityClass = (Class<T>) Class
							.forName("jp.co.kin.db.entity." + toJavaFileName(getPhysicalName(row)));
					Field<T> field = new Field<T>("", "", entityClass, null);

					if (!isCreatedDeleteMethod) {
						Method<T> deleteMethod = getDeleteMethod(field, source);
						source.addMethod(deleteMethod);
						isCreatedDeleteMethod = true;
					}
					if (!isCreatedUpdateMethod) {
						Method<T> updatMethod = getUpdatMethod(field, source);
						source.addMethod(updatMethod);
						isCreatedUpdateMethod = true;
					}

					if (!isCreatedInsertMethod) {
						Method<T> insertMethod = getCreateMethod(field, source);
						source.addMethod(insertMethod);
						isCreatedInsertMethod = true;
					}

				}
				FileConfig fileConf = getFileConfig(ExecuteType.DAO);
				fileConf.setFileName(toJavaFileName(table) + "Dao" + FileExtension.JAVA.getValue());
				fileConf.setData(build(source));
				FileFactory.create(fileConf);
			}
		} catch (Exception e) {
			LOG.error("", e);
		}

	}

	private void setCommonInfo(JavaSource source) {
		source.setPackage(new jp.co.kin.tool.source.Package("jp.co.kin.db.dao"));
		source.setClassType(ClassType.INTERFACE);
		source.setAccessType(AccessType.PUBLIC);
		source.addImplInterface(BaseDao.class);
		source.addImport(new Import(BaseDao.class));
		source.addClassAnnotation(Dao.class, "");
		source.addImport(new Import(Dao.class));
		source.addClassAnnotation(DaoRepository.class, "");
		source.addImport(new Import(DaoRepository.class));
	}

	private Method<T> getDeleteMethod(Field<T> field, JavaSource source) {

		Method<T> deleteMethod = new Method<T>(field, AccessType.PUBLIC) {

			@Override
			protected String getMethodName() {
				return "delete";
			}

			@Override
			public String toString() {
				final String TAB = "	";
				StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
				for (Entry<Class<?>, String> entry : annotationMap.entrySet()) {
					body.add(TAB + "@" + entry.getKey().getSimpleName() + entry.getValue());
				}
				body.add(TAB + this.accessType.getValue() + " int " + getMethodName() + "("
						+ signature.toString() + ");");

				return body.toString();
			}
		};
		Signature signature = new Signature();
		signature.addArgs(field.getClassType(), "entity");
		source.addImport(new Import(field.getClassType()));
		deleteMethod.setSignature(signature);

		deleteMethod.addAnnotation(Delete.class, "");
		source.addImport(new Import(Delete.class));

		return deleteMethod;
	}

	private Method<T> getUpdatMethod(Field<T> field, JavaSource source) {

		Method<T> updateMethod = new Method<T>(field, AccessType.PUBLIC) {

			@Override
			protected String getMethodName() {
				return "update";
			}

			@Override
			public String toString() {
				final String TAB = "	";
				StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
				for (Entry<Class<?>, String> entry : annotationMap.entrySet()) {
					body.add(TAB + "@" + entry.getKey().getSimpleName() + entry.getValue());
				}
				body.add(TAB + this.accessType.getValue() + " int " + getMethodName() + "("
						+ signature.toString() + ");");

				return body.toString();
			}
		};
		Signature signature = new Signature();
		signature.addArgs(field.getClassType(), "entity");
		source.addImport(new Import(field.getClassType()));
		updateMethod.setSignature(signature);

		updateMethod.addAnnotation(Update.class, "");
		source.addImport(new Import(Update.class));

		return updateMethod;
	}

	private Method<T> getCreateMethod(Field<T> field, JavaSource source) {

		Method<T> createMethod = new Method<T>(field, AccessType.PUBLIC) {

			@Override
			protected String getMethodName() {
				return "insert";
			}

			@Override
			public String toString() {
				final String TAB = "	";
				StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
				for (Entry<Class<?>, String> entry : annotationMap.entrySet()) {
					body.add(TAB + "@" + entry.getKey().getSimpleName() + entry.getValue());
				}
				body.add(TAB + this.accessType.getValue() + " int " + getMethodName() + "("
						+ signature.toString() + ");");

				return body.toString();
			}
		};
		Signature signature = new Signature();
		signature.addArgs(field.getClassType(), "entity");
		source.addImport(new Import(field.getClassType()));
		createMethod.setSignature(signature);

		createMethod.addAnnotation(Insert.class, "");
		source.addImport(new Import(Insert.class));

		return createMethod;
	}

	private String build(JavaSource source) {

		StringJoiner result = new StringJoiner(LineFeedType.CRLF.getValue() + LineFeedType.CRLF.getValue());

		// package情報
		result.add(buildPackage(source));

		// import情報
		result.add(buildImport(source.getImportList()));

		// class情報
		result.add(buildClassAnnotation(source.getClassAnnotationMap()) + LineFeedType.CRLF.getValue()
				+ buildClass(source) + buildInterfaces(source) + " {");

		// method情報
		result.add(buildMethods(source.getMethodList()));

		result.add("}");

		return result.toString();
	}

}
