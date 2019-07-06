package jp.co.kin.dashboard.attendRegist.service;

import java.util.List;

import jp.co.kin.web.service.BaseService;

public interface AttendRegistService extends BaseService {

	/**
	 * システム日時から20年分の月をリストを返す
	 *
	 * @return
	 */
	List<String> getYearList();

	/**
	 * 1月~12月のリストを返す
	 *
	 * @return
	 */
	List<String> getMonthList();
}
