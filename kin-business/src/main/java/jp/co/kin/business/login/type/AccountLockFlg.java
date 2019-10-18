package jp.co.kin.business.login.type;

import jp.co.kin.common.type.BaseEnum;

/**
 * 勤怠管理サイトのアカウントロックの列挙<br>
 * <ul>
 * <li>0:利用可能</li>
 * <li>1:利用不可</li>
 * </ul>
 * 
 * @since 1.0.0
 */
public enum AccountLockFlg implements BaseEnum {

	/** 利用可能 */
	USABLE("0"),
	/** 利用不可 */
	UNUSABLE("1");

	/** 値 */
	private String value;

	private AccountLockFlg(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static AccountLockFlg of(String value) {
		return BaseEnum.of(AccountLockFlg.class, value);
	}

}
