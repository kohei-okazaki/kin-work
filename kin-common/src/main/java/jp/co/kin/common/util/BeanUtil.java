package jp.co.kin.common.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Bean操作のUtilクラス
 */
public class BeanUtil {

	private BeanUtil() {
	}

	/**
	 * コピー時にコピーを行わないfieldかどうかを判定する<br>
	 * 以下の場合、そのfieldではコピーを行わない<br>
	 * <ul>
	 * <li><code>fieldName</code>が"serialVersionUID"の場合</li>
	 * <li><code>fieldName</code>がignoreListに含まれてる場合</li>
	 * </ul>
	 *
	 * @param ignoreList
	 *            無視リスト
	 * @param fieldName
	 *            フィールド名
	 * @return 判定結果
	 */
	private static boolean ignore(List<String> ignoreList, String fieldName) {
		return "serialVersionUID".equals(fieldName) || ignoreList.contains(fieldName);
	}

	/**
	 * コピー対象かどうか判定する
	 *
	 * @param src
	 *            Field コピー元のフィールド
	 * @param dest
	 *            Field コピー先のフィールド
	 * @return 判定結果
	 */
	private static boolean isCopyTarget(Field src, Field dest) {
		String sourceFieldName = src.getName();
		Class<?> sourcefieldType = src.getType();
		String targetFieldName = dest.getName();
		Class<?> targetFieldType = dest.getType();
		return targetFieldName.equals(sourceFieldName) && targetFieldType.equals(sourcefieldType);
	}

	/**
	 * targetがnullかどうか判定する<br>
	 * 判定結果:nullの場合true, それ以外の場合false<br>
	 *
	 * @param target
	 *            検査対象インスタンス
	 * @return 判定結果
	 */
	public static boolean isNull(Object target) {
		return Objects.isNull(target);
	}

	/**
	 * targetがnullでないかどうか判定する<br>
	 * 判定結果:nullの場合false, それ以外の場合true<br>
	 *
	 * @see jp.co.ha.common.util.BeanUtil#isNull
	 * @param target
	 *            検査対象インスタンス
	 * @return 判定結果
	 */
	public static boolean notNull(Object target) {
		return !isNull(target);
	}

	/**
	 * パラメータ引数にしているクラス型を取得する
	 *
	 * @param clazz
	 *            対象クラス
	 * @return クラス型
	 */
	public static Class<?> getParameterType(Class<?> clazz) {
		return getParameterType(clazz, 0);
	}

	/**
	 * パラメータ引数にしているクラス型を取得する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param position
	 *            パラメータ引数の位置
	 * @return クラス型
	 */
	public static Class<?> getParameterType(Class<?> clazz, int position) {
		ParameterizedType paramType = (ParameterizedType) clazz.getGenericSuperclass();
		return (Class<?>) paramType.getActualTypeArguments()[position];
	}

	/**
	 * 指定したクラス型のフィールドをリストで返す
	 *
	 * @param clazz
	 *            クラス型
	 * @return フィールドのリスト
	 */
	public static List<Field> getFieldList(Class<?> clazz) {
		List<Field> fieldList = new ArrayList<>();
		Class<?> tmpClass = clazz;
		while (BeanUtil.notNull(tmpClass)) {
			fieldList.addAll(List.of(tmpClass.getDeclaredFields()));
			tmpClass = tmpClass.getSuperclass();
		}
		return fieldList;
	}

	/**
	 * 指定したclazzのfieldNameのアクセサを返す
	 *
	 * @param fieldName
	 *            フィールド名
	 * @param clazz
	 *            クラス
	 * @param type
	 *            SETTER/GETTER
	 * @return アクセサメソッド
	 */
	public static Method getAccessor(String fieldName, Class<?> clazz, AccessorType type) {
		Method accessor = null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
			if (AccessorType.SETTER == type) {
				accessor = pd.getWriteMethod();
			} else if (AccessorType.GETTER == type) {
				accessor = pd.getReadMethod();
			} else {
				// LOG.error("AccessTypeの指定が不正です。accessType = " + type);
				accessor = null;
			}
		} catch (IntrospectionException e) {
			// LOG.warn("メソッドがみつかりません", e);
		}
		return accessor;
	}

	/**
	 * メソッドのアクセス列挙
	 *
	 * @see BeanUtil#getAccessor(String, Class, AccessorType)
	 */
	public static enum AccessorType {
		/** setter */
		SETTER,
		/** getter */
		GETTER;
	}
}
