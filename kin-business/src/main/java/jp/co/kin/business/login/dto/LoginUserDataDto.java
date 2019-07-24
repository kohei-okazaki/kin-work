package jp.co.kin.business.login.dto;

import java.time.LocalDateTime;

import jp.co.kin.common.bean.BaseDto;
import jp.co.kin.common.log.annotation.Mask;

/**
 * ログインユーザのDTO
 *
 */
public class LoginUserDataDto implements BaseDto {

	/** ログインID */
	private String loginId;
	/** ユーザID */
	private String userId;
	/** パスワード */
	@Mask
	private String password;
	/** ユーザ名 */
	private String userName;
	/** パスワード有効期限 */
	private LocalDateTime passwordExpire;
	/** ユーザ権限 */
	private String userAuth;
	/** 登録日時 */
	private LocalDateTime regDate;
	/** 更新日時 */
	private LocalDateTime updateDate;

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
	 * passwordExpireを返す
	 * 
	 * @return passwordExpire
	 *
	 */
	public LocalDateTime getPasswordExpire() {
		return passwordExpire;
	}

	/**
	 * passwordExpireを設定する
	 * 
	 * @param passwordExpire
	 *            passwordExpire
	 *
	 */
	public void setPasswordExpire(LocalDateTime passwordExpire) {
		this.passwordExpire = passwordExpire;
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

	/**
	 * regDateを返す
	 *
	 * @return regDate
	 *
	 */
	public LocalDateTime getRegDate() {
		return regDate;
	}

	/**
	 * regDateを設定する
	 *
	 * @param regDate
	 *            regDate
	 *
	 */
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	/**
	 * updateDateを返す
	 *
	 * @return updateDate
	 *
	 */
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	/**
	 * updateDateを設定する
	 *
	 * @param updateDate
	 *            updateDate
	 *
	 */
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

}
