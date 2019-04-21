package jp.co.kin.common.type;

public enum Algorithm implements BaseEnum {

	/** SHA-256 */
	SHA_256("SHA-256"),
	/** SHA-512 */
	SHA_512("SHA-512");

	private String value;

	private Algorithm(String value) {
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
	 * @return Algorithm
	 */
	public static Algorithm of(String value) {
		return BaseEnum.of(Algorithm.class, value);
	}
}
