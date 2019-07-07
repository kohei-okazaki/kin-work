package jp.co.kin.business.session;

import jp.co.kin.common.bean.BaseDto;
import jp.co.kin.common.log.annotation.Mask;

/**
 * session上で保持するログインユーザ情報
 *
 */
public class SessionLoginUser implements BaseDto {

	/** ログインID */
	private String loginId;
	/** パスワード */
	@Mask
	private String password;
	/** ユーザ名 */
	private String userName;
	/** ユーザ権限 */
	private String userAuth;

	/**
	 * loginIdを返す
	 *
	 * @return loginId
	 *
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * loginIdを設定する
	 *
	 * @param loginId
	 *            loginId
	 *
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * passwordを返す
	 *
	 * @return password
	 *
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * passwordを設定する
	 *
	 * @param password
	 *            password
	 *
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * userNameを返す
	 *
	 * @return userName
	 *
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * userNameを設定する
	 *
	 * @param userName
	 *            userName
	 *
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * userAuthを返す
	 *
	 * @return userAuth
	 *
	 */
	public String getUserAuth() {
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
		this.userAuth = userAuth;
	}

}
