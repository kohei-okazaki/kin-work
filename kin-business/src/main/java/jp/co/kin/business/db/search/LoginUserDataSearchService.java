package jp.co.kin.business.db.search;

import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.web.service.BaseService;

public interface LoginUserDataSearchService extends BaseService {

	public LoginUserDataDto search(String loginId);
}
