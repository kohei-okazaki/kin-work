package jp.co.kin.business.userRegist.dto;

import java.time.LocalDateTime;

import jp.co.kin.business.login.type.UserAuth;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.LocalDateTimeUtil;

public class UserBusinessProperties {

	/** 有効期限日時 */
	private LocalDateTime authDate;
	/** ユーザ権限 */
	private UserAuth userAuth;

	/**
	 * authDateを返す
	 *
	 * @return authDate
	 *
	 */
	public LocalDateTime getAuthDate() {
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
		this.authDate = LocalDateTimeUtil
				.toLocalDateTime(LocalDateTimeUtil.toLocalDate(authDate, DateFormatType.YYYYMMDD_NOSEP));
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
