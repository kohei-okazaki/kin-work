package jp.co.kin.business.db.create;

import jp.co.kin.db.entity.LoginUserData;
import jp.co.kin.web.service.BaseService;

/**
 * ログインユーザ情報作成サービスインターフェース
 *
 * @since 1.0.0
 *
 */
public interface LoginUserDataCreateService extends BaseService {

	void create(LoginUserData entity);
}
