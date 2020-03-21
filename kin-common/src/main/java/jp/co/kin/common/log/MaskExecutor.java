package jp.co.kin.common.log;

import java.lang.reflect.Field;

import jp.co.kin.common.log.annotation.Mask;

/**
 * マスク処理クラス
 *
 * @since 1.0.0
 */
public class MaskExecutor {

	/**
	 * マスク対象かどうか判定する<br>
	 * マスク対象の場合true, それ以外の場合false
	 *
	 * @param field
	 *            フィールド
	 * @return 判定結果
	 */
	public static boolean isMask(Field field) {
		return field.isAnnotationPresent(Mask.class);
	}

	/**
	 * マスク文字列を返す
	 *
	 * @param field
	 *            フィールド
	 * @return マスク文字列
	 */
	public static String getMask(Field field) {
		return field.getAnnotation(Mask.class).value();
	}

}
