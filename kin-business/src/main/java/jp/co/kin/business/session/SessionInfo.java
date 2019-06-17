package jp.co.kin.business.session;

/**
 * Session保持データ
 *
 */
public class SessionInfo {

	/** sessionログインユーザ */
	private SessionLoginUser loginUser;

	/**
	 * loginUserを返す
	 *
	 * @return loginUser
	 *
	 */
	public SessionLoginUser getLoginUser() {
		return loginUser;
	}

	/**
	 * loginUserを設定する
	 *
	 * @param loginUser
	 *            loginUser
	 *
	 */
	public void setLoginUser(SessionLoginUser loginUser) {
		this.loginUser = loginUser;
	}

}
