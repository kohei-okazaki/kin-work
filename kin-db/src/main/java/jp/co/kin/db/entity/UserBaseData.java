package jp.co.kin.db.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * ユーザ基本情報 Entity
 *
 */
@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class UserBaseData extends BaseEntity {

	/** ユーザID */
	@Id
	private String userId;
	/** 企業コード */
	private String companyCode;
	/** 登録日時 */
	private LocalDateTime regDate;
	/** 更新日時 */
	private LocalDateTime updateDate;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCode() {
		return companyCode;
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
