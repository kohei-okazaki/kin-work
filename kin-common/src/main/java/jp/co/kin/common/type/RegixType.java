package jp.co.kin.common.type;

/**
 * RegixType
 *
 */
public enum RegixType implements BaseEnum {
	/** 半角数字 */
	HALF_NUMBER("^[0-9]*$"),
	/** 半角数字とピリオド */
	HALF_NUMBER_PERIOD("^[0-9.]*$"),
	/** 半角英数字 */
	HALF_CHAR("^[0-9a-zA-Z]*$"),
	/** URL */
	URL("http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?"),
	/** メールアドレス */
	MAIL_ADDRESS("[A-Za-z0-9._+]+@[A-Za-z]+.[A-Za-z]"),
	/** フラグ */
	FLAG("[01]"),
	/** 浮動小数 */
	DECIMAL("^?(0|[1-9]\\d*)(\\.\\d+|)$");

	private String value;

	private RegixType(String value) {
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
	 * @return RegixType
	 */
	public static RegixType of(String value) {
		return BaseEnum.of(RegixType.class, value);
	}
}
