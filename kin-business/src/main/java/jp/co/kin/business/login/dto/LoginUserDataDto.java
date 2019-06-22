package jp.co.kin.business.login.dto;

import java.util.Date;

import jp.co.kin.business.session.SessionLoginUser;
import jp.co.kin.common.bean.BaseDto;
import jp.co.kin.common.log.annotation.Mask;

/**
 * ログイン画面のDTO
 *
 */
public class LoginUserDataDto implements BaseDto {

	/** ログインID */
	private String loginId;
	/** パスワード */
	@Mask
	private String password;
	/** ユーザ名 */
	private String userName;
	/** パスワード有効期限 */
	private Date passwordExpire;
	/** ユーザ権限 */
	private String userAuth;
	/** 登録日時 */
	private Date regDate;
	/** 更新日時 */
	private Date updateDate;
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
	public Date getPasswordExpire() {
		return passwordExpire;
	}

	/**
	 * passwordExpireを設定する
	 *
	 * @param passwordExpire
	 *            passwordExpire
	 *
	 */
	public void setPasswordExpire(Date passwordExpire) {
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
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * regDateを設定する
	 *
	 * @param regDate
	 *            regDate
	 *
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * updateDateを返す
	 *
	 * @return updateDate
	 *
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * updateDateを設定する
	 *
	 * @param updateDate
	 *            updateDate
	 *
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
