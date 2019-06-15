package jp.co.kin.business.login.type;

import jp.co.kin.common.type.BaseEnum;

/**
 * 勤怠管理サイトのユーザ権限の列挙<br>
 * 今後、権限を追加する場合、本列挙に追加してください
 * <ul>
 * <li>一般</li>
 * <li>管理者</li>
 * </ul>
 */
public enum UserAuth implements BaseEnum {

	/** 一般 */
	COMMON("0"),
	/** 管理者 */
	MANAGE("1");

	private String value;

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
