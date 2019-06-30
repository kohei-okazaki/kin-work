package jp.co.kin.dashboard.loginUserRegist.form;

import jp.co.kin.common.log.annotation.Mask;
import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

/**
 * ログインユーザ登録画面form
 *
 */
public class LoginUserRegistForm implements BaseForm {

	/** ログインID */
	@Required
	private String loginId;
	/** パスワード */
	@Mask
	@Required
	private String password;
	/** パスワード */
	@Required
	private String confirmPassword;
	/** ユーザ名 */
	@Required
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
	 * confirmPasswordを返す
	 *
	 * @return confirmPassword
	 *
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * confirmPasswordを設定する
	 *
	 * @param confirmPassword
	 *            confirmPassword
	 *
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
