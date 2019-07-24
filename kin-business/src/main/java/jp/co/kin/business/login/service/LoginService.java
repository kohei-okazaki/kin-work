package jp.co.kin.business.login.service;

import jp.co.kin.business.login.dto.LoginCheckResult;
import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.web.service.BaseService;

public interface LoginService extends BaseService {

	/**
	 * ログインユーザ情報のログインチェックを行う
	 * 
	 * @param dto
	 *            ログインユーザのDTO
	 * @return
	 */
	LoginCheckResult checkLogin(LoginUserDataDto dto);
}
