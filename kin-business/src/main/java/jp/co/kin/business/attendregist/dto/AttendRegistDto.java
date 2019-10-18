package jp.co.kin.business.attendregist.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jp.co.kin.common.bean.BaseDto;

/**
 * 勤怠登録のDto
 * 
 * @since 1.0.0
 *
 */
public class AttendRegistDto implements BaseDto {

	/** ユーザID */
	private String userId;
	/** 企業コード */
	private String companyCode;
	/** 勤怠情報登録日時 */
	private LocalDate workDataRegDate;
	/** 始業日時 */
	private LocalDateTime workStartDate;
	/** 終業日時 */
	private LocalDateTime workEndDate;
	/** 実労働時間 */
	private String actualWorkTime;

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
	 * workDataRegDateを返す
	 *
	 * @return workDataRegDate
	 *
	 */
	public LocalDate getWorkDataRegDate() {
		return workDataRegDate;
	}

	/**
	 * workDataRegDateを設定する
	 *
	 * @param workDataRegDate
	 *            workDataRegDate
	 *
	 */
	public void setWorkDataRegDate(LocalDate workDataRegDate) {
		this.workDataRegDate = workDataRegDate;
	}

	/**
	 * workStartDateを返す
	 *
	 * @return workStartDate
	 *
	 */
	public LocalDateTime getWorkStartDate() {
		return workStartDate;
	}

	/**
	 * workStartDateを設定する
	 *
	 * @param workStartDate
	 *            workStartDate
	 *
	 */
	public void setWorkStartDate(LocalDateTime workStartDate) {
		this.workStartDate = workStartDate;
	}

	/**
	 * workEndDateを返す
	 *
	 * @return workEndDate
	 *
	 */
	public LocalDateTime getWorkEndDate() {
		return workEndDate;
	}

	/**
	 * workEndDateを設定する
	 *
	 * @param workEndDate
	 *            workEndDate
	 *
	 */
	public void setWorkEndDate(LocalDateTime workEndDate) {
		this.workEndDate = workEndDate;
	}

	/**
	 * actualWorkTimeを返す
	 *
	 * @return actualWorkTime
	 *
	 */
	public String getActualWorkTime() {
		return actualWorkTime;
	}

	/**
	 * actualWorkTimeを設定する
	 *
	 * @param actualWorkTime
	 *            actualWorkTime
	 *
	 */
	public void setActualWorkTime(String actualWorkTime) {
		this.actualWorkTime = actualWorkTime;
	}

}
