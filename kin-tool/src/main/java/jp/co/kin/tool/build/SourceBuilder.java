package jp.co.kin.tool.build;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.CollectionUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.source.Import;
import jp.co.kin.tool.source.JavaSource;
import jp.co.kin.tool.source.Method;
import jp.co.kin.tool.type.CellPositionType;
import jp.co.kin.tool.type.ClassType;

public abstract class SourceBuilder extends BaseBuilder {

	/**
	 * <code>name</code>をキャメルケースに変換する<br>
	 * (例)<br>
	 * TEST_NAME -> testName<br>
	 *
	 * @param name
	 *            テーブル名
	 * @return キャメルケースに変換した文字列
	 */
	protected String toCamelCase(String name) {

		String result = name.toLowerCase();
		while (result.indexOf(StringUtil.UNDER_SCORE) != -1) {
			int pos = result.indexOf(StringUtil.UNDER_SCORE);
			String target = result.substring(pos, pos + 2);
			String after = target.replace(StringUtil.UNDER_SCORE, StringUtil.EMPTY).toUpperCase();
			result = result.replaceFirst(target, after);
		}

		return result;
	}

	/**
	 * Javaファイル名に変換する<br>
	 * (例)<br>
	 * TEST_NAME -> TestName<br>
	 *
	 * @param fileName
	 *            ファイル名
	 * @return Javaファイル名
	 */
	protected String toJavaFileName(String fileName) {

		String result = toCamelCase(fileName);
		// 先頭の文字列を大文字に変換
		Character startChar = result.charAt(0);
		Character large = Character.toUpperCase(result.charAt(0));

		return result.replaceFirst(startChar.toString(), large.toString());
	}

	protected String getPhysicalName(Row row) {
		return row.getCell(CellPositionType.PHYSICAL_NAME).getValue();
	}

	/**
	 * Package部分を組み立てる
	 *
	 * @param source
	 *            JavaSource
	 * @return Package部分
	 */
	protected String buildPackage(JavaSource source) {
		return source.getPackage().toString();
	}

	/**
	 * import部分を組み立てる
	 *
	 * @param importList
	 *            importリスト
	 * @return import部分
	 */
	protected String buildImport(List<Import> importList) {

		List<String> strImportList = new ArrayList<>();
		importList.stream().filter(e -> !strImportList.contains(e.toString())).map(e -> e.toString())
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
	 * @return クラスに付与するアノテーション部分
	 */
	protected String buildClassAnnotation(List<Class<?>> classAnnotationList,
			Function<Class<?>, String> function) {

		StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
		for (Class<?> clazz : classAnnotationList) {
			String str = "";
			if (BeanUtil.notNull(function)) {
				str = function.apply(clazz);
			}
			body.add("@" + clazz.getSimpleName() + str);
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
	protected String buildClass(JavaSource source) {

		String accessType = source.getAccessType().getValue();
		String classType = source.getClassType().getValue();
		String className = source.getClassName();
		StringJoiner body = new StringJoiner(StringUtil.SPACE);

		return body.add(accessType).add(classType).add(className).toString();
	}

	/**
	 * Classの継承部分を組み立てる<br>
	 * <cpde>extends AAAA</code>
	 *
	 * @param source
	 *            JavaSource
	 * @return Classの継承部分
	 */
	protected String buildExtendsClass(JavaSource source) {

		if (BeanUtil.isNull(source.getExtendsClass())) {
			return "";
		}

		String prefix = "extends";

		return " " + prefix + " " + source.getExtendsClass().getSimpleName();
	}

	/**
	 * interfaceのリストの継承部分を組み立てる<br>
	 * <code>implements AAAA, BBBB</code><br>
	 * or<br>
	 * <code>extends AAAA, BBBB</code>
	 *
	 * @param source
	 *            JavaSource
	 * @return interfaceのリストの継承部分
	 */
	protected String buildInterfaces(JavaSource source) {

		if (CollectionUtil.isEmpty(source.getImplInterfaceList())) {
			return "";
		}

		String prefix = source.getClassType().equals(ClassType.CLASS) ? "implements" : "extends";
		StringJoiner body = new StringJoiner(StringUtil.COMMA + StringUtil.SPACE);
		source.getImplInterfaceList().stream().forEach(e -> body.add(e.getSimpleName()));

		return " " + prefix + " " + body.toString();
	}

	protected String buildMethods(List<Method<?>> methodList) {
		StringJoiner body = new StringJoiner(StringUtil.NEW_LINE + StringUtil.NEW_LINE);
		methodList.stream().forEach(e -> body.add(e.toString()));
		return body.toString();
	}

}
