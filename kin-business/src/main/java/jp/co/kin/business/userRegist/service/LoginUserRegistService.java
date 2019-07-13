package jp.co.kin.business.userRegist.service;

import jp.co.kin.business.userRegist.dto.UserRegistDto;
import jp.co.kin.web.service.BaseService;

public interface LoginUserRegistService extends BaseService {

	void regist(UserRegistDto dto);

	boolean isDuplicateLoginId(UserRegistDto dto);
}
