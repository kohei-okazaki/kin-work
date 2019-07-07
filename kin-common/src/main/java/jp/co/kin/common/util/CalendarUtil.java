package jp.co.kin.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarUtil {

	private static final List<String> WEEK_DAY = List.of("sunDay", "monday", "tuesDay", "wednesDay",
			"thursDay", "friDay", "saturDay");

	private CalendarUtil() {
	}

	/**
	 * システム日付のカレンダーを返す
	 *
	 * @return カレンダー
	 */
	public static Calendar getSysCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * システム日付のカレンダーの最終日を返す
	 *
	 * @return 最終日
	 */
	public static int getLastDay() {
		return getLastDay(getSysCalendar());
	}

	/**
	 * 指定されたカレンダーの最終日を返す
	 *
	 * @param c
	 *            カレンダー
	 * @return 最終日
	 */
	public static int getLastDay(Calendar c) {
		return c.getActualMaximum(Calendar.DATE);
	}

	public static Calendar toCalendar(Date date) {
		Calendar calendar = getSysCalendar();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 指定したカレンダーから対応する曜日を返す
	 *
	 * @see CalendarUtil#WEEK_DAY
	 * @param c
	 *            カレンダー
	 * @return 曜日
	 */
	public static String getWeekDay(Calendar c) {
		return WEEK_DAY.get(c.get(Calendar.DAY_OF_WEEK) - 1);
	}

}
