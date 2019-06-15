package jp.co.kin.business.login.dto;

import jp.co.kin.business.session.SessionLoginUser;
import jp.co.kin.common.bean.BaseDto;

/**
 * ログイン画面のDTO
 *
 */
public class LoginUserDataDto implements BaseDto {

	/** ログインID */
	private String loginId;
	/** パスワード */
	private String password;
	/** session上で保持するログインユーザ */
	private SessionLoginUser sessionLoginUser;

	public LoginUserDataDto() {
		this.sessionLoginUser = new SessionLoginUser();
	}

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
	 * sessionLoginUserを返す
	 *
	 * @return sessionLoginUser
	 *
	 */
	public SessionLoginUser getSessionLoginUser() {
		return sessionLoginUser;
	}

	/**
	 * sessionLoginUserを設定する
	 *
	 * @param sessionLoginUser
	 *            sessionLoginUser
	 *
	 */
	public void setSessionLoginUser(SessionLoginUser sessionLoginUser) {
		this.sessionLoginUser = sessionLoginUser;
	}

}
