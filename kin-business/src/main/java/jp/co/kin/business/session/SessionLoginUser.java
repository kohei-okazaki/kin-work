package jp.co.kin.business.session;

/**
 * session上で保持するログインユーザ
 *
 */
public class SessionLoginUser {

	/** ログインID */
	private String loginId;
	/** ユーザ名 */
	private String userName;

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

}
