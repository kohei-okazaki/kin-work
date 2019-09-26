package jp.co.kin.common.log;

import java.util.Optional;

/**
 * Logの追加情報を管理するクラス
 *
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
}
