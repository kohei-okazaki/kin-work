package jp.co.kin.business.db.create;

import jp.co.kin.db.entity.LoginUserData;
import jp.co.kin.web.service.BaseService;

/**
 * ログインユーザ情報作成サービスインターフェース
 *
 * @since 1.0.0
 */
public interface LoginUserDataCreateService extends BaseService {

	/**
	 * 作成
	 *
	 * @param entity
	 *            ログインユーザ情報 Entity
	 */
	void create(LoginUserData entity);
}
