package jp.co.kin.business.session;

/**
 * Session保持データ
 *
 */
public class SessionInfo {

	private LoginUser loginUser;

	/**
	 * loginUserを返す
	 * 
	 * @return loginUser
	 *
	 */
	public LoginUser getLoginUser() {
		return loginUser;
	}

	/**
	 * loginUserを設定する
	 * 
	 * @param loginUser
	 *            loginUser
	 *
	 */
	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}

}
