package jp.co.kin.web.type;

import jp.co.kin.common.type.BaseEnum;

/**
 * Webリクエストの処理結果の列挙
 *
 * @since 1.0.0
 */
public enum ResultType implements BaseEnum {

	/** SUCCESS */
	SUCCESS("0", "成功"),
	/** FAILURE */
	FAILURE("1", "失敗");

	/** 値 */
	private String value;
	/** メッセージ */
	private String message;

	private ResultType(String value, String message) {
		this.value = value;
		this.message = message;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public String getMessage() {
		return this.message;
	}

	public static ResultType of(String value) {
		return BaseEnum.of(ResultType.class, value);
	}

}
