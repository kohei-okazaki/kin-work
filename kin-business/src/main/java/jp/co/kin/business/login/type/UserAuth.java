package jp.co.kin.business.login.type;

import jp.co.kin.common.type.BaseEnum;

/**
 * 勤怠管理サイトのユーザ権限の列挙<br>
 * 今後、権限を追加する場合、本列挙に追加してください
 * <ul>
 * <li>0:一般</li>
 * <li>1:管理者</li>
 * </ul>
 *
 * @since 1.0.0
 */
public enum UserAuth implements BaseEnum {

	/** 一般 */
	COMMON("0"),
	/** 管理者 */
	MANAGE("1");

	/** 値 */
	private String value;

	/**
	 * コンストラクタ
	 *
	 * @param value
	 *            値
	 */
	private UserAuth(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static UserAuth of(String value) {
		return BaseEnum.of(UserAuth.class, value);
	}

}
