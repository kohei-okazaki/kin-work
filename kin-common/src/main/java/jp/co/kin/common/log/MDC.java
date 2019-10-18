package jp.co.kin.common.log;

import java.util.Optional;

import jp.co.kin.common.util.StringUtil;

/**
 * Logの追加情報を管理するクラス
 * 
 * @since 1.0.0
 */
public class MDC {

	private MDC() {
	}

	public static void put(String key, String value) {
		org.slf4j.MDC.put(key, value);
	}

	public static String get(String key) {
		return Optional.ofNullable(org.slf4j.MDC.get(key)).orElse("<NULL>");
	}

	public static void remove(String key) {
		org.slf4j.MDC.remove(key);
	}

	public static boolean isContains(String key) {
		return StringUtil.hasValue(get(key));
	}
}
