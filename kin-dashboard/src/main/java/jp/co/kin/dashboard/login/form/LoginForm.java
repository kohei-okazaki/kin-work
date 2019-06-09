package jp.co.kin.dashboard.login.form;

import jp.co.kin.web.form.BaseForm;

/**
 * ログイン画面form
 */
public class LoginForm implements BaseForm {

	private String loginId;
	private String password;

	/**
	 * loginIdを返す
	 *
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            loginIdを設定する
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * passwordを返す
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            passwordを設定する
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
