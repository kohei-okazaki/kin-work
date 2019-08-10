package jp.co.kin.business.db.search;

import jp.co.kin.business.userregist.dto.UserBaseDataDto;
import jp.co.kin.web.service.BaseService;

public interface UserBaseDataSearchService extends BaseService {

	UserBaseDataDto searchByUserId(String userId);

}
