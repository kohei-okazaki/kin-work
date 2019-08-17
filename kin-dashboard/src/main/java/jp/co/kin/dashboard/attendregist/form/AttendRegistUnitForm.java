package jp.co.kin.dashboard.attendregist.form;

import java.math.BigDecimal;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.validator.annotation.Pattern;
import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

/**
 * 1日あたりの勤怠データ
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
	/** 始業時間(時) */
	private String workStartHour;
	/** 始業時間(分) */
	private String workStartMinute;
	/** 終業時間(時) */
	private String workEndHour;
	/** 終業時間(分) */
	private String workEndMinute;

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
	 * workStartHourを返す
	 *
	 * @return workStartHour
	 *
	 */
	public String getWorkStartHour() {
		return workStartHour;
	}

	/**
	 * workStartHourを設定する
	 *
	 * @param workStartHour
	 *            workStartHour
	 *
	 */
	public void setWorkStartHour(String workStartHour) {
		this.workStartHour = workStartHour;
	}

	/**
	 * workStartMinuteを返す
	 *
	 * @return workStartMinute
	 *
	 */
	public String getWorkStartMinute() {
		return workStartMinute;
	}

	/**
	 * workStartMinuteを設定する
	 *
	 * @param workStartMinute
	 *            workStartMinute
	 *
	 */
	public void setWorkStartMinute(String workStartMinute) {
		this.workStartMinute = workStartMinute;
	}

	/**
	 * workEndHourを返す
	 *
	 * @return workEndHour
	 *
	 */
	public String getWorkEndHour() {
		return workEndHour;
	}

	/**
	 * workEndHourを設定する
	 *
	 * @param workEndHour
	 *            workEndHour
	 *
	 */
	public void setWorkEndHour(String workEndHour) {
		this.workEndHour = workEndHour;
	}

	/**
	 * workEndMinuteを返す
	 *
	 * @return workEndMinute
	 *
	 */
	public String getWorkEndMinute() {
		return workEndMinute;
	}

	/**
	 * workEndMinuteを設定する
	 *
	 * @param workEndMinute
	 *            workEndMinute
	 *
	 */
	public void setWorkEndMinute(String workEndMinute) {
		this.workEndMinute = workEndMinute;
	}

}
