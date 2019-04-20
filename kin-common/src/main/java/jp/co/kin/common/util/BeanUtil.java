package jp.co.kin.common.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;

public class BeanUtil {

	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(BeanUtil.class);

	private BeanUtil() {
	}

	/**
	 * <code>src</code>のフィールドを<code>dest</code>のフィールドにコピーする<br>
	 * コピー先のクラスと同じフィールド名の場合コピー元のフィールドに値を設定する<br>
	 *
	 * @param src
	 *     コピー元
	 * @param dest
	 *     コピー先
	 */
	public static void copy(Object src, Object dest) {
		copy(src, dest, Collections.emptyList());
	}

	/**
	 * <code>src</code>のフィールドを<code>dest</code>のフィールドにコピーする<br>
	 * コピー先のクラスと同じフィールド名の場合、コピー元のフィールドに値を設定する<br>
	 * コピー時に無視リストの名前のフィールドの場合、コピーを行わない。<br>
	 *
	 * @param src
	 *     コピー元
	 * @param dest
	 *     コピー先
	 * @param ignoreList
	 *     無視リスト
	 */
	public static void copy(Object src, Object dest, List<String> ignoreList) {

		// コピー元のクラス型
		Class<?> srcClass = src.getClass();
		// コピー先のクラス型
		Class<?> destClass = dest.getClass();
		try {
			for (Field targetField : BeanUtil.getFieldList(destClass)) {
				if (ignore(ignoreList, targetField.getName())) {
					continue;
				}

				for (Field sourceField : BeanUtil.getFieldList(srcClass)) {
					if (isCopyTarget(sourceField, targetField)) {
						// getter呼び出し
						Method getter = getAccessor(sourceField.getName(), srcClass, AccessorType.GETTER);
						// setter呼び出し
						Method setter = getAccessor(sourceField.getName(), destClass, AccessorType.SETTER);

						// 値を設定
						setter.invoke(dest, getter.invoke(src));
					}
				}
			}
		} catch (IllegalAccessException e) {
			LOG.warn("アクセスに失敗", e);
		} catch (IllegalArgumentException e) {
			LOG.warn("不正な引数", e);
		} catch (InvocationTargetException e) {
			LOG.warn("フィールドのアクセスに失敗", e);
		}
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
	 *     無視リスト
	 * @param fieldName
	 *     フィールド名
	 * @return 判定結果
	 */
	private static boolean ignore(List<String> ignoreList, String fieldName) {
		return "serialVersionUID".equals(fieldName) || ignoreList.contains(fieldName);
	}

	/**
	 * コピー対象かどうか判定する
	 *
	 * @param src
	 *     Field コピー元のフィールド
	 * @param dest
	 *     Field コピー先のフィールド
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
	 *     検査対象インスタンス
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
	 *     検査対象インスタンス
	 * @return 判定結果
	 */
	public static boolean notNull(Object target) {
		return !isNull(target);
	}

	/**
	 * パラメータ引数にしているクラス型を取得する
	 *
	 * @param clazz
	 *     対象クラス
	 * @return クラス型
	 */
	public static Class<?> getParameterType(Class<?> clazz) {
		return getParameterType(clazz, 0);
	}

	/**
	 * パラメータ引数にしているクラス型を取得する
	 *
	 * @param clazz
	 *     対象クラス
	 * @param position
	 *     パラメータ引数の位置
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
	 *     クラス型
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
	 *     フィールド名
	 * @param clazz
	 *     クラス
	 * @param type
	 *     SETTER/GETTER
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
				LOG.error("AccessTypeの指定が不正です。accessType = " + type);
			}
		} catch (IntrospectionException e) {
			LOG.warn("メソッドがみつかりません", e);
		}
		return accessor;
	}

	/**
	 * メソッドのアクセス列挙<br>
	 * @see BeanUtil#getAccessor(String, Class, AccessorType)
	 *
	 */
	public static enum AccessorType {
		/** setter */
		SETTER,
		/** getter */
		GETTER;
	}

}
