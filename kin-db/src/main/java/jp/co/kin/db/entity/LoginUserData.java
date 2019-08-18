package jp.co.kin.db.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

import jp.co.kin.common.crypt.annotation.Crypt;
import jp.co.kin.common.log.annotation.Mask;

/**
 * ログインユーザ情報 Entity
 *
 */
@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class LoginUserData extends BaseEntity {

	/** ログインID */
	@Id
	private String loginId;
	/** ユーザID */
	private String userId;
	/** ユーザ名 */
	private String userName;
	/** パスワード */
	@Mask
	@Crypt
	private String password;
	/** パスワード有効期限 */
	private LocalDateTime passwordExpire;
	/** ユーザ権限 */
	private String userAuth;
	/** アカウントロックフラグ */
	private String accountLockFlg;
	/** ログイン失敗回数 */
	private BigDecimal loginFailCount;
	/** 登録日時 */
	private LocalDateTime regDate;
	/** 更新日時 */
	private LocalDateTime updateDate;

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPasswordExpire(LocalDateTime passwordExpire) {
		this.passwordExpire = passwordExpire;
	}

	public LocalDateTime getPasswordExpire() {
		return passwordExpire;
	}

	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}

	public String getUserAuth() {
		return userAuth;
	}

	public void setAccountLockFlg(String accountLockFlg) {
		this.accountLockFlg = accountLockFlg;
	}

	public String getAccountLockFlg() {
		return accountLockFlg;
	}

	public void setLoginFailCount(BigDecimal loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public BigDecimal getLoginFailCount() {
		return loginFailCount;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

}
