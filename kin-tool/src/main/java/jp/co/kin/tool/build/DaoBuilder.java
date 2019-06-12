package jp.co.kin.tool.build;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.seasar.doma.Dao;

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
import jp.co.kin.tool.source.Import;
import jp.co.kin.tool.source.JavaSource;
import jp.co.kin.tool.type.AccessType;
import jp.co.kin.tool.type.ClassType;
import jp.co.kin.tool.type.ExecuteType;

public class DaoBuilder extends SourceBuilder {

	@Build
	public void execute() {
		Excel excel = super.reader.read();
		excel.activeSheet("TABLE_LIST");

		for (String table : this.targetTableList) {
			JavaSource source = new JavaSource();
			setCommonInfo(source);
			for (Row row : excel.getRowList()) {
				if (isTargetTable(row, table)) {
					source.setClassName(toJavaFileName(getPhysicalName(row)) + "Dao");
				}
			}
			FileConfig fileConf = getFileConfig(ExecuteType.DAO);
			fileConf.setFileName(toJavaFileName(table) + "Dao" + FileExtension.JAVA.getValue());
			fileConf.setData(build(source));
			FileFactory.create(fileConf);
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

	/**
	 * パッケージ部分を組み立てる
	 *
	 * @param source
	 *            Javaソース
	 * @return パッケージ
	 */
	private String buildPackage(JavaSource source) {
		return source.getPackage().toString();
	}

	/**
	 * import部分を組み立てる
	 *
	 * @param importList
	 *            インポート文のリスト
	 * @return インポート
	 */
	private String buildImport(List<Import> importList) {

		List<String> strImportList = new ArrayList<>();
		importList.stream()
				.filter(e -> !strImportList.contains(e.toString()))
				.map(e -> e.toString())
				.forEach(e -> strImportList.add(e));

		StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
		strImportList.stream().forEach(e -> body.add(e));
		return body.toString();
	}

}