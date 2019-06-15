package jp.co.kin.common.type;

public enum LineFeedType implements BaseEnum {

	/** CR */
	CR("\r"),
	/** LF */
	LF("\n"),
	/** CRLF */
	CRLF("\r\n");

	/** 値 */
	private String value;

	private LineFeedType(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static LineFeedType of(String value) {
		return BaseEnum.of(LineFeedType.class, value);
	}

}
