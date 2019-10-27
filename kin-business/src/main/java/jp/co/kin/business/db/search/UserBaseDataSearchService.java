package jp.co.kin.business.db.search;

import jp.co.kin.business.userregist.dto.UserBaseDataDto;
import jp.co.kin.web.service.BaseService;

/**
 * ユーザ基本情報検索サービスインターフェース
 *
 * @since 1.0.0
 */
public interface UserBaseDataSearchService extends BaseService {

	UserBaseDataDto searchByUserId(String userId);

}
