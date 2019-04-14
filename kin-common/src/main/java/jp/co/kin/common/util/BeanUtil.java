package jp.co.kin.common.util;

import java.util.Objects;

public class BeanUtil {

	private BeanUtil() {
	}

	public static boolean isNull(Object object) {
		return Objects.isNull(object);
	}

	public static boolean isNonNull(Object object) {
		return !isNull(object);
	}

}
