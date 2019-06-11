package jp.co.kin.tool.build;

import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.type.CellPositionType;

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

	/**
	 * 物理名を取得
	 *
	 * @param row
	 *            Row
	 * @return
	 */
	protected String getPhysicalName(Row row) {
		return row.getCell(CellPositionType.PHYSICAL_NAME).getValue();
	}
}
