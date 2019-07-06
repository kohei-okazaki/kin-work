package jp.co.kin.common.type;

public enum DateFormatType implements BaseEnum {

	/** YYYY */
	YYYY("YYYY"),
	/** MM */
	MM("MM"),
	/** DD */
	DD("dd"),
	/** YYYYMMDD */
	YYYYMMDD_NOSEP("yyyyMMdd"),
	/** YYYY/MM/DD */
	YYYYMMDD("yyyy/MM/dd"),
	/** YYYY/MM/DD HH:mm:ss */
	YYYYMMDD_HHMMSS("yyyy/MM/dd HH:mm:ss"),
	/** YYYYMMDD_HHmmss */
	YYYYMMDD_HHMMSS_NOSEP("yyyyMMdd_HHmmss");

	/** 名前 */
	private String value;

	private DateFormatType(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static DateFormatType of(String value) {
		return BaseEnum.of(DateFormatType.class, value);
	}

}
