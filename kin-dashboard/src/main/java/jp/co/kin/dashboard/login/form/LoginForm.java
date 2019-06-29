package jp.co.kin.dashboard.login.form;

import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

/**
 * ログイン画面form
 *
 */
public class LoginForm implements BaseForm {

	/** ログインID */
	@Required
	private String loginId;
	/** パスワード */
	@Required
	private String password;

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

}
