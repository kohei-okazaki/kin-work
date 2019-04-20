package jp.co.kin.common.type;

/**
 * Charset
 *
 */
public enum Charset implements BaseEnum {

	/** MS932 */
	MS_932("MS932"),
	/** UTF-8 */
	UTF_8("UTF-8");

	private String value;

	private Charset(String value) {
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
	 * @return Charset
	 */
	public static Charset of(String value) {
		return BaseEnum.of(Charset.class, value);
	}
}