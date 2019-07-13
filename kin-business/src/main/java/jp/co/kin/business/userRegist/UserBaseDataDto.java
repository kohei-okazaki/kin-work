package jp.co.kin.business.userRegist;

import java.util.Date;

import jp.co.kin.common.bean.BaseDto;

public class UserBaseDataDto implements BaseDto {

	/** ユーザID */
	private String userId;
	/** 企業コード */
	private String companyCode;
	/** 登録日時 */
	private Date regDate;
	/** 更新日時 */
	private Date updateDate;

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
