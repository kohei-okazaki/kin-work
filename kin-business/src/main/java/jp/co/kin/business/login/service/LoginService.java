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

	/**
	 * ログイン失敗回数をインクリメントし、更新後のログイン失敗回数が3回目の場合、アカウントロックフラグを1に更新する
	 *
	 * @param result
	 *            LoginCheckResult
	 */
	void updateFailLoginUserData(LoginUserDataDto dto);
}
