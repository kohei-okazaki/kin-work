package jp.co.kin.business.db.update;

import jp.co.kin.db.entity.LoginUserData;
import jp.co.kin.web.service.BaseService;

/**
 * ログインユーザ情報更新サービスインターフェース
 *
 * @since 1.0.0
 *
 */
public interface LoginUserDataUpdateService extends BaseService {

	/**
	 * ログイン失敗回数を更新する
	 *
	 * @param entity
	 *            ログインユーザ情報
	 */
	void updateFailCount(LoginUserData entity);

	/**
	 * ログイン失敗回数とアカウントロックフラグを更新する
	 *
	 * @param entity
	 *            ログインユーザ情報
	 */
	void updateAccountLock(LoginUserData entity);

}
