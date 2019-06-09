package jp.co.kin.tool.type;

import jp.co.kin.common.type.BaseEnum;

public enum AccessType implements BaseEnum {

	/** public */
	PUBLIC("public"),
	/** protected */
	PROTECTED("protected"),
	/** デフォルト */
	DEFAULT(""),
	/** private */
	PRIVATE("private");

	private AccessType(String value) {
		this.value = value;
	}

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
	 * @return AccessType
	 */
	public static AccessType of(String value) {
		return BaseEnum.of(AccessType.class, value);
	}
}
