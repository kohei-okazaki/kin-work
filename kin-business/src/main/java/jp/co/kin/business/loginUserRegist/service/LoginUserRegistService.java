package jp.co.kin.business.loginUserRegist.service;

import jp.co.kin.business.loginUserRegist.dto.LoginUserRegistDto;
import jp.co.kin.web.service.BaseService;

public interface LoginUserRegistService extends BaseService {

	void regist(LoginUserRegistDto dto);
}
