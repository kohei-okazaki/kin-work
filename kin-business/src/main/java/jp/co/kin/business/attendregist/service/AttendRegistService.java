package jp.co.kin.business.attendregist.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jp.co.kin.business.attendregist.dto.AttendBusinessCalendar;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.web.service.BaseService;

public interface AttendRegistService extends BaseService {

	/**
	 * システム日時から10年後までの年のリストを返す
	 *
	 * @return
	 */
	List<BigDecimal> getYearList();

	/**
	 * 月のリストを返す
	 *
	 * @return
	 */
	List<BigDecimal> getMonthList();

	/**
	 * 指定されたユーザIDに紐づくユーザ基本情報.企業コード の定時情報マスタを検索する
	 *
	 * @param userId
	 *            ユーザOD
	 * @return
	 */
	OntimeDto getOntimeDto(String userId);

	/**
	 * 対象日付のカレンダー情報をリストを返す
	 * 
	 * @param targetDate
	 *            対象日付
	 * @return
	 */
	List<AttendBusinessCalendar> getBusinessCalendarList(LocalDate targetDate);

}
