package jp.co.kin.business.loginUserRegist.dto;

import jp.co.kin.common.bean.BaseDto;
import jp.co.kin.common.log.annotation.Mask;

/**
 * ログインユーザ登録DTO
 *
 */
public class LoginUserRegistDto implements BaseDto {

	/** ログインID */
	private String loginId;
	/** パスワード */
	@Mask
	private String password;
	/** 確認用パスワード */
	@Mask
	private String confirmPassword;
	/** ユーザ名 */
	private String userName;
	/** 登録成功フラグ */
	private boolean isRegistSuccess;

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

	/**
	 * isRegistSuccessを返す
	 *
	 * @return isRegistSuccess
	 *
	 */
	public boolean isRegistSuccess() {
		return isRegistSuccess;
	}

	/**
	 * isRegistSuccessを設定する
	 *
	 * @param isRegistSuccess
	 *            isRegistSuccess
	 *
	 */
	public void setRegistSuccess(boolean isRegistSuccess) {
		this.isRegistSuccess = isRegistSuccess;
	}

}
