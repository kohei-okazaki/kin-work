package jp.co.kin.business.attendRegist.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jp.co.kin.business.attendRegist.dto.AttendBusinessCalendar;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.web.service.BaseService;

public interface AttendRegistService extends BaseService {

	/**
	 * システム日時から10年分の月をリストを返す
	 *
	 * @return
	 */
	List<BigDecimal> getYearList();

	/**
	 * 1月~12月のリストを返す
	 *
	 * @return
	 */
	List<BigDecimal> getMonthList();

	/**
	 * 指定されたユーザIDと一致する定時情報を取得
	 *
	 * @param userId
	 *            ユーザID
	 * @return
	 */
	OntimeDto getOntimeDto(String userId);

	/**
	 * 指定した日付の業務用カレンダーリストを返す
	 * 
	 * @param targetDate
	 *            日付
	 * @return
	 */
	List<AttendBusinessCalendar> getBusinessCalendarList(LocalDate targetDate);
}
