package jp.co.kin.common.type;

/**
 * DateFormatType
 *
 */
public enum DateFormatType implements BaseEnum {
	/** YYYY/MM/DD */
	YYYYMMDD("yyyy/MM/dd"),
	/** YYYY/MM/DD HH:mm:ss */
	YYYYMMDD_HHMMSS("yyyy/MM/dd HH:mm:ss"),
	/** YYYYMMDD_HHmmss */
	YYYYMMDD_HHMMSS_NOSEP("yyyyMMdd_HHmmss");

	private String value;

	private DateFormatType(String value) {
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getValue() {
		return this.value;
	}

	/**
	 * @see jp.co.kin.common.type.BaseEnum#of(Class, String)
	 * @param value
	 *            値
	 * @return DateFormatType
	 */
	public static DateFormatType of(String value) {
		return BaseEnum.of(DateFormatType.class, value);
	}
}
