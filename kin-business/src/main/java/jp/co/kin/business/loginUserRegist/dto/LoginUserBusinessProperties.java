package jp.co.kin.business.loginUserRegist.dto;

import java.util.Date;

import jp.co.kin.business.login.type.UserAuth;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.DateUtil;

public class LoginUserBusinessProperties {

	/** 有効期限日時 */
	private Date authDate;
	/** ユーザ権限 */
	private UserAuth userAuth;

	/**
	 * authDateを返す
	 *
	 * @return authDate
	 *
	 */
	public Date getAuthDate() {
		return authDate;
	}

	/**
	 * authDateを設定する
	 *
	 * @param authDate
	 *            authDate
	 *
	 */
	public void setAuthDate(String authDate) {
		this.authDate = DateUtil.toDate(authDate, DateFormatType.YYYYMMDD_NOSEP);
	}

	/**
	 * userAuthを返す
	 *
	 * @return userAuth
	 *
	 */
	public UserAuth getUserAuth() {
		return userAuth;
	}

	/**
	 * userAuthを設定する
	 *
	 * @param userAuth
	 *            userAuth
	 *
	 */
	public void setUserAuth(String userAuth) {
		this.userAuth = UserAuth.of(userAuth);
	}

}
