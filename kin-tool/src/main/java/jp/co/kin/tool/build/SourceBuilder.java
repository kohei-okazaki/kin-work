package jp.co.kin.tool.build;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.CollectionUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.source.Field;
import jp.co.kin.tool.source.Import;
import jp.co.kin.tool.source.JavaSource;
import jp.co.kin.tool.source.Method;
import jp.co.kin.tool.type.CellPositionType;
import jp.co.kin.tool.type.ClassType;

/**
 * SourceBuilder
 *
 * @since 1.0.0
 *
 */
public abstract class SourceBuilder extends BaseBuilder {

    /**
     * <code>name</code>をキャメルケースに変換する<br>
     * (例)<br>
     * TEST_NAME -> testName<br>
     *
     * @param name
     *     テーブル名
     * @return キャメルケースに変換した文字列
     */
    protected String toCamelCase(String name) {

        String result = name.toLowerCase();
        while (result.indexOf(StringUtil.UNDER_SCORE) != -1) {
            int pos = result.indexOf(StringUtil.UNDER_SCORE);
            String target = result.substring(pos, pos + 2);
            String after = target.replace(StringUtil.UNDER_SCORE, StringUtil.EMPTY)
                    .toUpperCase();
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
     *     ファイル名
     * @return Javaファイル名
     */
    protected String toJavaFileName(String fileName) {

        String result = toCamelCase(fileName);
        // 先頭の文字列を大文字に変換
        Character startChar = result.charAt(0);
        Character large = Character.toUpperCase(startChar);

        return result.replaceFirst(startChar.toString(), large.toString());
    }

    protected String getPhysicalName(Row row) {
        return row.getCell(CellPositionType.PHYSICAL_NAME).getValue();
    }

    protected String getLogicalName(Row row) {
        return row.getCell(CellPositionType.LOGICAL_NAME).getValue();
    }

    /**
     * Package部分を組み立てる
     *
     * @param source
     *     JavaSource
     * @return Package部分
     */
    protected String buildPackage(JavaSource source) {
        return source.getPackage().toString();
    }

    /**
     * import部分を組み立てる
     *
     * @param importList
     *     importリスト
     * @return import部分
     */
    protected String buildImport(List<Import> importList) {

        List<String> strImportList = new ArrayList<>();
        importList.stream().filter(e -> !strImportList.contains(e.toString()))
                .map(e -> e.toString())
                .forEach(e -> strImportList.add(e));

        StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
        strImportList.stream().forEach(e -> body.add(e));
        return body.toString();
    }

    /**
     * クラスに付与するJavaDoc部分を組み立てる
     *
     * @param source
     *     生成するJavaファイルのリソース
     * @return クラスに付与するJavaDoc
     */
    protected String buildClassJavaDoc(JavaSource source) {
        StringJoiner sj = new StringJoiner(StringUtil.NEW_LINE);
        sj.add("/**");
        sj.add(" * " + source.getClassJavaDoc());
        sj.add(" *");
        sj.add(" */");
        return sj.toString();
    }

    /**
     * クラスに付与するアノテーション部分を組み立てる
     *
     * @param annotationMap
     *     クラスに付与するアノテーションのMap
     * @return クラスに付与するアノテーション部分
     */
    protected String buildClassAnnotation(Map<Class<?>, String> annotationMap) {

        StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
        annotationMap.entrySet().stream()
                .forEach(e -> body.add("@" + e.getKey().getSimpleName() + e.getValue()));

        return body.toString();
    }

    /**
     * クラス名部分を組み立てる<br>
     * ex<br>
     * <code>public class XXXX</code>
     *
     * @param source
     *     生成するJavaファイルのリソース
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
     *     生成するJavaファイルのリソース
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
     *     生成するJavaファイルのリソース
     * @return interfaceのリストの継承部分
     */
    protected String buildInterfaces(JavaSource source) {

        if (CollectionUtil.isEmpty(source.getImplInterfaceList())) {
            return "";
        }

        String prefix = source.getClassType().equals(ClassType.CLASS) ? "implements"
                : "extends";
        StringJoiner body = new StringJoiner(StringUtil.COMMA + StringUtil.SPACE);
        source.getImplInterfaceList().stream().forEach(e -> body.add(e.getSimpleName()));

        return " " + prefix + " " + body.toString();
    }

    /**
     * フィールド部分を組み立てる
     *
     * @param fieldList
     *     フィールドリスト
     * @return フィールド部分
     */
    protected String buildFields(List<Field> fieldList) {
        StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
        fieldList.stream().forEach(e -> body.add(e.toString()));
        return body.toString();
    }

    /**
     * メソッド部分を組み立てる
     *
     * @param methodList
     *     メソッドリスト
     * @return メソッド部分
     */
    protected String buildMethods(List<Method> methodList) {
        StringJoiner body = new StringJoiner(StringUtil.NEW_LINE + StringUtil.NEW_LINE);
        methodList.stream().forEach(e -> body.add(e.toString()));
        return body.toString();
    }

}
