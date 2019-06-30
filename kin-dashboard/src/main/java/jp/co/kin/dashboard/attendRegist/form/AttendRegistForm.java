package jp.co.kin.dashboard.attendRegist.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.co.kin.web.form.BaseForm;

/**
 * 勤怠登録画面form
 *
 */
public class AttendRegistForm implements BaseForm {

	/** 日にちリスト */
	private List<BigDecimal> dayList;
	/** 曜日リスト */
	private List<String> weekDayList;
	/** 始業時間リスト */
	private List<String> workStartTimeList;
	/** 終業時間リスト */
	private List<String> workEndTimeList;

	public AttendRegistForm() {
		this.dayList = new ArrayList<>();
		this.weekDayList = new ArrayList<>();
		this.workStartTimeList = new ArrayList<>();
		this.workEndTimeList = new ArrayList<>();
	}

	/**
	 * dayListを返す
	 *
	 * @return dayList
	 *
	 */
	public List<BigDecimal> getDayList() {
		return dayList;
	}

	/**
	 * dayListを設定する
	 *
	 * @param dayList
	 *            dayList
	 *
	 */
	public void setDayList(List<BigDecimal> dayList) {
		this.dayList = dayList;
	}

	public void addDay(BigDecimal day) {
		this.dayList.add(day);
	}

	/**
	 * weekDayListを返す
	 *
	 * @return weekDayList
	 *
	 */
	public List<String> getWeekDayList() {
		return weekDayList;
	}

	/**
	 * weekDayListを設定する
	 *
	 * @param weekDayList
	 *            weekDayList
	 *
	 */
	public void setWeekDayList(List<String> weekDayList) {
		this.weekDayList = weekDayList;
	}

	public void addWeekDay(String weekDay) {
		this.weekDayList.add(weekDay);
	}

	/**
	 * workStartTimeListを返す
	 *
	 * @return workStartTimeList
	 *
	 */
	public List<String> getWorkStartTimeList() {
		return workStartTimeList;
	}

	/**
	 * workStartTimeListを設定する
	 *
	 * @param workStartTimeList
	 *            workStartTimeList
	 *
	 */
	public void setWorkStartTimeList(List<String> workStartTimeList) {
		this.workStartTimeList = workStartTimeList;
	}

	/**
	 * workEndTimeListを返す
	 *
	 * @return workEndTimeList
	 *
	 */
	public List<String> getWorkEndTimeList() {
		return workEndTimeList;
	}

	/**
	 * workEndTimeListを設定する
	 *
	 * @param workEndTimeList
	 *            workEndTimeList
	 *
	 */
	public void setWorkEndTimeList(List<String> workEndTimeList) {
		this.workEndTimeList = workEndTimeList;
	}

}
