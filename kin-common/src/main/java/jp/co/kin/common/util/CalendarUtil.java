package jp.co.kin.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarUtil {

	private static final List<String> WEEK_DAY = List.of("sunDay", "monday", "tuesDay", "wednesDay",
			"thursDay", "friDay", "saturDay");

	private CalendarUtil() {
	}

	public static Calendar getSysCalendar() {
		return Calendar.getInstance();
	}

	public static int getLastDay() {
		return getSysCalendar().getActualMaximum(Calendar.DATE);
	}

	public static Calendar toCalendar(Date date) {
		Calendar calendar = getSysCalendar();
		calendar.setTime(date);
		return calendar;
	}

	public static String getWeekDay(Calendar c) {
		return WEEK_DAY.get(c.get(Calendar.DAY_OF_WEEK) - 1);
	}

}
