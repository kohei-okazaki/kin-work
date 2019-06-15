package jp.co.kin.common.type;

public enum Algorithm implements BaseEnum {

	/** AES */
	AES("AES"),
	/** SHA-256 */
	SHA_256("SHA-256"),
	/** SHA-512 */
	SHA_512("SHA-512");

	/** 値 */
	private String value;

	private Algorithm(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static Algorithm of(String value) {
		return BaseEnum.of(Algorithm.class, value);
	}
}
