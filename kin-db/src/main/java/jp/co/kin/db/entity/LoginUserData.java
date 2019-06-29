package jp.co.kin.db.entity;

import java.util.Date;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

import jp.co.kin.common.crypt.annotation.Crypt;
import jp.co.kin.common.log.annotation.Mask;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class LoginUserData extends BaseEntity {

	/** ログインID */
	@Id
	private String loginId;
	/** ユーザ名 */
	private String userName;
	/** パスワード */
	@Mask
	@Crypt
	private String password;
	/** パスワード有効期限 */
	private Date passwordExpire;
	/** ユーザ権限 */
	private String userAuth;
	/** 登録日時 */
	private Date regDate;
	/** 更新日時 */
	private Date updateDate;

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginId() {
		return loginId;
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

	public void setPasswordExpire(Date passwordExpire) {
		this.passwordExpire = passwordExpire;
	}

	public Date getPasswordExpire() {
		return passwordExpire;
	}

	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}

	public String getUserAuth() {
		return userAuth;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

}
