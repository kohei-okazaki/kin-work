package jp.co.kin.common.type;

public enum LineFeedType implements BaseEnum {

	/** CR */
	CR("\r"),
	/** LF */
	LF("\n"),
	/** CRLF */
	CRLF("\r\n");

	/**
	 * コンストラクタ
	 *
	 * @param value
	 *            値
	 */
	private LineFeedType(String value) {
		this.value = value;
	}

	/** 値 */
	private String value;

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
	 * @return LineFeedType
	 */
	public static LineFeedType of(String value) {
		return BaseEnum.of(LineFeedType.class, value);
	}

}
