package jp.co.kin.business.loginUserRegist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.LoginUserDataCreateService;
import jp.co.kin.business.db.search.LoginUserDataSearchService;
import jp.co.kin.business.loginUserRegist.dto.LoginUserBusinessProperties;
import jp.co.kin.business.loginUserRegist.dto.LoginUserRegistDto;
import jp.co.kin.business.loginUserRegist.service.LoginUserRegistService;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.db.entity.LoginUserData;

@Service
public class LoginUserRegistServiceImpl implements LoginUserRegistService {

	@Autowired
	private LoginUserDataCreateService loginUserDataCreateService;
	@Autowired
	private LoginUserBusinessProperties loginUserBusinessProperties;
	@Autowired
	private LoginUserDataSearchService loginUserDataSearchService;

	@Override
	public void regist(LoginUserRegistDto dto) {

		LoginUserData entity = new LoginUserData();
		BeanUtil.copy(dto, entity);

		entity.setPasswordExpire(loginUserBusinessProperties.getAuthDate());
		entity.setUserAuth(loginUserBusinessProperties.getUserAuth().getValue());
		loginUserDataCreateService.create(entity);

		dto.setRegistSuccess(true);
	}

	@Override
	public boolean isDuplicateLoginId(LoginUserRegistDto dto) {
		return loginUserDataSearchService.searchCountByLoginId(dto.getLoginId()) != 0;
	}

}
