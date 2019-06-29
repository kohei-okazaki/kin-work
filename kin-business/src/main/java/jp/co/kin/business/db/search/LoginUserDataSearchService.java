package jp.co.kin.business.db.search;

import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.web.service.BaseService;

public interface LoginUserDataSearchService extends BaseService {

	LoginUserDataDto searchByLoginId(String loginId);

	int searchCountByLoginId(String loginId);
}
