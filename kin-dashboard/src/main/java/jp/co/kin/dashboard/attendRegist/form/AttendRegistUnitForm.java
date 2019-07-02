package jp.co.kin.dashboard.attendRegist.form;

import java.math.BigDecimal;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.validator.annotation.Pattern;
import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

/**
 * 1行あたりの勤怠データ
 *
 */
public class AttendRegistUnitForm implements BaseForm {

	/** 日にち */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER)
	private BigDecimal day;
	/** 曜日 */
	@Required
	@Pattern(regixPattern = RegixType.HALF_CHAR)
	private String weekDay;
	/** 始業時間 */
	@Required
	private String workStartTime;
	/** 終業時間 */
	@Required
	private String workEndTime;

	/**
	 * dayを返す
	 *
	 * @return day
	 *
	 */
	public BigDecimal getDay() {
		return day;
	}

	/**
	 * dayを設定する
	 *
	 * @param day
	 *            day
	 *
	 */
	public void setDay(BigDecimal day) {
		this.day = day;
	}

	/**
	 * weekDayを返す
	 *
	 * @return weekDay
	 *
	 */
	public String getWeekDay() {
		return weekDay;
	}

	/**
	 * weekDayを設定する
	 *
	 * @param weekDay
	 *            weekDay
	 *
	 */
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	/**
	 * workStartTimeを返す
	 *
	 * @return workStartTime
	 *
	 */
	public String getWorkStartTime() {
		return workStartTime;
	}

	/**
	 * workStartTimeを設定する
	 *
	 * @param workStartTime
	 *            workStartTime
	 *
	 */
	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}

	/**
	 * workEndTimeを返す
	 *
	 * @return workEndTime
	 *
	 */
	public String getWorkEndTime() {
		return workEndTime;
	}

	/**
	 * workEndTimeを設定する
	 *
	 * @param workEndTime
	 *            workEndTime
	 *
	 */
	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}

}
