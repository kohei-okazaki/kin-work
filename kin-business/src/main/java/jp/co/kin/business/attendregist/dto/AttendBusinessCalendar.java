package jp.co.kin.business.attendregist.dto;

import java.math.BigDecimal;

import jp.co.kin.common.bean.BaseDto;

public class AttendBusinessCalendar implements BaseDto {

	/** 日にち */
	private BigDecimal day;
	/** 曜日 */
	private String weekDay;
	/** 始業日時(時) */
	private String workStartDateHour;
	/** 始業日時(分) */
	private String workStartDateMinute;
	/** 終業日時(時) */
	private String workEndDateHour;
	/** 終業日時(分) */
	private String workEndDateMinute;

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
	 * workStartDateHourを返す
	 *
	 * @return workStartDateHour
	 *
	 */
	public String getWorkStartDateHour() {
		return workStartDateHour;
	}

	/**
	 * workStartDateHourを設定する
	 *
	 * @param workStartDateHour
	 *            workStartDateHour
	 *
	 */
	public void setWorkStartDateHour(String workStartDateHour) {
		this.workStartDateHour = workStartDateHour;
	}

	/**
	 * workStartDateMinuteを返す
	 *
	 * @return workStartDateMinute
	 *
	 */
	public String getWorkStartDateMinute() {
		return workStartDateMinute;
	}

	/**
	 * workStartDateMinuteを設定する
	 *
	 * @param workStartDateMinute
	 *            workStartDateMinute
	 *
	 */
	public void setWorkStartDateMinute(String workStartDateMinute) {
		this.workStartDateMinute = workStartDateMinute;
	}

	/**
	 * workEndDateHourを返す
	 *
	 * @return workEndDateHour
	 *
	 */
	public String getWorkEndDateHour() {
		return workEndDateHour;
	}

	/**
	 * workEndDateHourを設定する
	 *
	 * @param workEndDateHour
	 *            workEndDateHour
	 *
	 */
	public void setWorkEndDateHour(String workEndDateHour) {
		this.workEndDateHour = workEndDateHour;
	}

	/**
	 * workEndDateMinuteを返す
	 *
	 * @return workEndDateMinute
	 *
	 */
	public String getWorkEndDateMinute() {
		return workEndDateMinute;
	}

	/**
	 * workEndDateMinuteを設定する
	 *
	 * @param workEndDateMinute
	 *            workEndDateMinute
	 *
	 */
	public void setWorkEndDateMinute(String workEndDateMinute) {
		this.workEndDateMinute = workEndDateMinute;
	}

}
