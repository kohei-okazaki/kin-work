package jp.co.kin.business.userregist.dto;

import jp.co.kin.common.bean.BaseDto;
import jp.co.kin.common.log.annotation.Mask;

/**
 * ユーザ登録DTO
 * 
 * @since 1.0.0
 */
public class UserRegistDto implements BaseDto {

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
	/** 企業コード */
	private String companyCode;
	/** ユーザID */
	private String userId;
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
	 * companyCodeを返す
	 *
	 * @return companyCode
	 *
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * companyCodeを設定する
	 *
	 * @param companyCode
	 *            companyCode
	 *
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * userIdを返す
	 *
	 * @return userId
	 *
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userIdを設定する
	 *
	 * @param userId
	 *            userId
	 *
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
