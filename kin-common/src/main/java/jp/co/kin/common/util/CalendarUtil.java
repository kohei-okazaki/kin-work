package jp.co.kin.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.co.kin.common.type.BaseEnum;

/**
 * カレンダー処理のUtilクラス
 *
 * @see LocalDateTimeUtil
 */
@Deprecated(since = "1.0.0")
public class CalendarUtil {

	private static final List<String> WEEK_DAY = List.of("sunday", "monday", "tuesday", "wednesday",
			"thursday", "friday", "saturday");

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

	private static enum WeekDay implements BaseEnum {

		/** 日曜日 */
		SUNDAY("sunday", Calendar.SUNDAY),
		/** 月曜日 */
		MONDAY("monday", Calendar.MONDAY),
		/** 火曜日 */
		TUESDAY("tuesday", Calendar.TUESDAY),
		/** 水曜日 */
		WEDNESDAY("wednesday", Calendar.WEDNESDAY),
		/** 木曜日 */
		THURSDAY("thursday", Calendar.THURSDAY),
		/** 金曜日 */
		FRIDAY("friday", Calendar.FRIDAY),
		/** 土曜日 */
		SATURDAY("saturday", Calendar.SATURDAY);

		/** 値 */
		private String value;
		/** 位置 */
		private int posistion;

		private WeekDay(String value, int posistion) {
			this.value = value;
			this.posistion = posistion;
		}

		@Override
		public String getValue() {
			return this.value;
		}

		public int getPosition() {
			return this.posistion;
		}

	}

}
