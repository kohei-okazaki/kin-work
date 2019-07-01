package jp.co.kin.business.attendRegist;

import java.math.BigDecimal;

public class AttendBusinessCalendor {

	private BigDecimal day;
	private String weekDay;

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

}
