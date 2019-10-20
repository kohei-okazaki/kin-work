package jp.co.kin.business.attendregist.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jp.co.kin.business.attendregist.dto.AttendBusinessCalendar;
import jp.co.kin.business.attendregist.dto.AttendRegistDto;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.web.service.BaseService;

/**
 * 勤怠登録サービスインターフェース
 *
 * @since 1.0.0
 *
 */
public interface AttendRegistService extends BaseService {

	/**
	 * システム日時から10年後までの年のリストを返す
	 *
	 * @return 年のリスト
	 */
	List<BigDecimal> getYearList();

	/**
	 * 月のリストを返す
	 *
	 * @return 月のリスト
	 */
	List<BigDecimal> getMonthList();

	/**
	 * 指定されたユーザIDに紐づくユーザ基本情報.企業コードの定時情報マスタを検索する
	 *
	 * @param userId
	 *            ユーザID
	 * @return 定時情報マスタ
	 */
	OntimeDto getOntimeDto(String userId);

	/**
	 * 対象日付のカレンダー情報をリストを返す
	 *
	 * @param targetDate
	 *            対象日付
	 * @return カレンダー情報をリスト
	 */
	List<AttendBusinessCalendar> getBusinessCalendarList(LocalDate targetDate);

	/**
	 * 勤怠登録情報を登録する
	 *
	 * @param dto
	 *            勤怠登録情報
	 */
	void registDailyWorkData(AttendRegistDto dto);

}
