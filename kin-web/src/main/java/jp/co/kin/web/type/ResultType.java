package jp.co.kin.web.type;

import jp.co.kin.common.type.BaseEnum;

/**
 * ResultType
 *
 */
public enum ResultType implements BaseEnum {

	/** Success */
	SUCCESS("0"),
	/** Failure */
	FAILURE("1");

	private String value;

	private ResultType(String value) {
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
	 * @return ResultType
	 */
	public static ResultType of(String value) {
		return BaseEnum.of(ResultType.class, value);
	}
}
