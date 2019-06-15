package jp.co.kin.common.type;

public enum CommonFlag implements BaseEnum {

	/** true */
	TRUE("1"),
	/** false */
	FALSE("0");

	/** 値 */
	private String value;

	private CommonFlag(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static CommonFlag of(String value) {
		return BaseEnum.of(CommonFlag.class, value);
	}
}
