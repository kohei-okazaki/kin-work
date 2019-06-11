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
		StringBuilder result = new StringBuilder();

		// package情報
		result.append(buildPackage(source))
				.append(LineFeedType.CRLF.getValue() + LineFeedType.CRLF.getValue());

		// import情報
		result.append(buildImport(source.getImportList()))
				.append(LineFeedType.CRLF.getValue() + LineFeedType.CRLF.getValue());

		// class情報
		result.append(buildClassAnnotation(source.getClassAnnotationList()) + LineFeedType.CRLF.getValue()
				+ buildClass(source) + StringUtil.SPACE + buildInterfaces(source.getImplInterfaceList()) + " {")
				.append(LineFeedType.CRLF.getValue() + LineFeedType.CRLF.getValue());

		result.append("}");

		return result.toString();
	}

	/**
	 * パッケージ部分を組み立てる
	 *
	 * @param source
	 *            Javaソース
	 * @return
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

	/**
	 * クラスに付与するアノテーション部分を組み立てる
	 *
	 * @param classAnnotationList
	 *            クラスに付与するアノテーションのリスト
	 * @return クラスに付与するアノテーション部
	 */
	private String buildClassAnnotation(List<Class<?>> classAnnotationList) {
		StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
		for (Class<?> clazz : classAnnotationList) {
			body.add("@" + clazz.getSimpleName());
		}
		return body.toString();
	}

	/**
	 * クラス名部分を組み立てる<br>
	 * ex<br>
	 * <code>public class XXXX</code>
	 *
	 * @param source
	 *            生成するJavaファイルのリソース
	 * @return クラス名
	 */
	private String buildClass(JavaSource source) {
		String accessType = source.getAccessType().getValue();
		String classType = source.getClassType().getValue();
		String className = source.getClassName();
		StringJoiner body = new StringJoiner(StringUtil.SPACE);
		return body.add(accessType).add(classType).add(className).toString();
	}

	/**
	 * 指定したinterfaceのリストをクラスに継承させる<br>
	 * <code>implements AAAA, BBBB</code>
	 *
	 * @param interfaceList
	 *            インターフェースリスト
	 * @return インターフェース
	 */
	private String buildInterfaces(List<Class<?>> interfaceList) {
		String prefix = "extends ";
		StringJoiner body = new StringJoiner(StringUtil.COMMA + StringUtil.SPACE);
		interfaceList.stream().forEach(e -> body.add(e.getSimpleName()));
		return prefix + body.toString();
	}

}
