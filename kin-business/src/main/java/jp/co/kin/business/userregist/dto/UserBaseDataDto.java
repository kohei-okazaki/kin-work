package jp.co.kin.business.userregist.dto;

import java.time.LocalDateTime;

import jp.co.kin.common.bean.BaseDto;

/**
 * ユーザ基本情報のDto
 * 
 * @since 1.0.0
 *
 */
public class UserBaseDataDto implements BaseDto {

	/** ユーザID */
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
