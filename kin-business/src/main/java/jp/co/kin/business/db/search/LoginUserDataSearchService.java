package jp.co.kin.business.db.search;

import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.web.service.BaseService;

/**
 * ログインユーザ情報検索サービス実装クラス
 *
 * @since 1.0.0
 *
 */
public interface LoginUserDataSearchService extends BaseService {

	LoginUserDataDto searchByLoginId(String loginId);

	int searchCountByLoginId(String loginId);
}
