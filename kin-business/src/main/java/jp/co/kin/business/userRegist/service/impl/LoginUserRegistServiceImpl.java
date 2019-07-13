package jp.co.kin.business.userRegist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.LoginUserDataCreateService;
import jp.co.kin.business.db.create.UserBaseDataCreateService;
import jp.co.kin.business.db.search.LoginUserDataSearchService;
import jp.co.kin.business.userRegist.dto.UserBusinessProperties;
import jp.co.kin.business.userRegist.dto.UserRegistDto;
import jp.co.kin.business.userRegist.service.LoginUserRegistService;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.db.entity.LoginUserData;
import jp.co.kin.db.entity.UserBaseData;

@Service
public class LoginUserRegistServiceImpl implements LoginUserRegistService {

	@Autowired
	private LoginUserDataCreateService loginUserDataCreateService;
	@Autowired
	private UserBusinessProperties loginUserBusinessProperties;
	@Autowired
	private LoginUserDataSearchService loginUserDataSearchService;
	@Autowired
	private UserBaseDataCreateService userBaseDataCreateService;

	@Override
	public void regist(UserRegistDto dto) {

		registLoginUserData(dto);
		registUserBaseData(dto);
		dto.setRegistSuccess(true);
	}

	@Override
	public boolean isDuplicateLoginId(UserRegistDto dto) {
		return loginUserDataSearchService.searchCountByLoginId(dto.getLoginId()) != 0;
	}

	private void registLoginUserData(UserRegistDto dto) {

		LoginUserData entity = new LoginUserData();
		BeanUtil.copy(dto, entity);

		entity.setPasswordExpire(loginUserBusinessProperties.getAuthDate());
		entity.setUserAuth(loginUserBusinessProperties.getUserAuth().getValue());
		loginUserDataCreateService.create(entity);

	}

	private void registUserBaseData(UserRegistDto dto) {

		UserBaseData entity = new UserBaseData();
		BeanUtil.copy(dto, entity);
		String userId = "KC" + dto.getLoginId();
		entity.setUserId(userId);
		userBaseDataCreateService.create(entity);

	}

}
