package jp.co.kin.business.attendRegist.service;

import java.math.BigDecimal;
import java.util.List;

import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.web.service.BaseService;

public interface AttendRegistService extends BaseService {

	/**
	 * システム日時から20年分の月をリストを返す
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
}
