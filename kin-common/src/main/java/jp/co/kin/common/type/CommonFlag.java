package jp.co.kin.common.type;

/**
 * CommonFlag
 *
 */
public enum CommonFlag implements BaseEnum {

	/** true */
	TRUE("1"),
	/** false */
	FALSE("0");

	private String value;

	private CommonFlag(String value) {
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
	 *     値
	 * @return CommonFlag
	 */
	public static CommonFlag of(String value) {
		return BaseEnum.of(CommonFlag.class, value);
	}
}
