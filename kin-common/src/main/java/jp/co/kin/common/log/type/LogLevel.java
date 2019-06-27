package jp.co.kin.common.log.type;

import jp.co.kin.common.type.BaseEnum;

public enum LogLevel implements BaseEnum {

	/** TRACE */
	TRACE("TRACE"),
	/** DEBUG */
	DEBUG("DEBUG"),
	/** INFO */
	INFO("INFO"),
	/** WARN */
	WARN("WARN"),
	/** ERROR */
	ERROR("ERROR"),
	/** FATAL */
	FATAL("FATAL");

	/** 値 */
	private String value;

	private LogLevel(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static LogLevel of(String value) {
		return BaseEnum.of(LogLevel.class, value);
	}

	public boolean is(LogLevel logLevel) {
		return this == logLevel;
	}

}
