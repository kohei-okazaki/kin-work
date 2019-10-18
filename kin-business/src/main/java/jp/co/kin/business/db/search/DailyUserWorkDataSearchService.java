package jp.co.kin.business.db.search;

import java.time.LocalDate;
import java.util.List;

import jp.co.kin.business.attendregist.dto.AttendRegistDto;
import jp.co.kin.web.service.BaseService;

/**
 * 日別ユーザ勤怠情報検索サービスインターフェース
 * 
 * @since 1.0.0
 *
 */
public interface DailyUserWorkDataSearchService extends BaseService {

	/**
	 * 指定されたユーザIDと日時に対応する日別ユーザ勤怠情報のDtoを検索する
	 *
	 * @param userId
	 *            ユーザID
	 * @param targetDate
	 *            対象日時
	 * @return
	 */
	List<AttendRegistDto> searchList(String userId, LocalDate targetDate);
}
