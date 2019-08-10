package jp.co.kin.business.userregist.service;

import jp.co.kin.business.userregist.dto.UserRegistDto;
import jp.co.kin.web.service.BaseService;

public interface LoginUserRegistService extends BaseService {

	void regist(UserRegistDto dto);

	boolean isDuplicateLoginId(UserRegistDto dto);
}
