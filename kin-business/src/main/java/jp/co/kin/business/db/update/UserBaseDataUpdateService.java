package jp.co.kin.business.db.update;

import jp.co.kin.db.entity.UserBaseData;
import jp.co.kin.web.service.BaseService;

/**
 * ユーザ基本情報更新サービスインターフェース
 *
 * @since 1.0.0
 */
public interface UserBaseDataUpdateService extends BaseService {

	/**
	 * ユーザ基本情報を更新する
	 *
	 * @param entity
	 *            UserBaseData
	 */
	void update(UserBaseData entity);
}
