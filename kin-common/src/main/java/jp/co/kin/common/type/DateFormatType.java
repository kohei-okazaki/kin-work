package jp.co.kin.common.type;

/**
 * 日付型と文字列型の日時を変換する際に使用するフォーマットの列挙
 * 
 * @since 1.0.0
 *
 */
public enum DateFormatType implements BaseEnum {

	/** YYYY */
	YYYY("YYYY"),
	/** MM */
	MM("MM"),
	/** DD */
	DD("dd"),
	/** HH */
	HH("HH"),
	/** mm */
	MI("mm"),
	/** YYYYMMDD */
	YYYYMMDD_NOSEP("yyyyMMdd"),
	/** YYYY/MM/DD */
	YYYYMMDD("yyyy/MM/dd"),
	/** YYYY/MM/DD HH:mm:ss */
	YYYYMMDD_HHMMSS("yyyy/MM/dd HH:mm:ss"),
	/** YYYYMMDD_HHmmss */
	YYYYMMDD_HHMMSS_NOSEP("yyyyMMddHHmmss");

	/** 値 */
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
