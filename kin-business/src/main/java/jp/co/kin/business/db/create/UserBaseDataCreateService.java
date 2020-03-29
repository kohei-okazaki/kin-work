package jp.co.kin.business.db.create;

import jp.co.kin.db.entity.UserBaseData;
import jp.co.kin.web.service.BaseService;

/**
 * ユーザ基本情報作成サービスインターフェース
 *
 * @since 1.0.0
 */
public interface UserBaseDataCreateService extends BaseService {

    void create(UserBaseData entity);

}
