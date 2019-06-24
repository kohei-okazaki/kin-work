package jp.co.kin.business.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.search.LoginUserDataSearchService;
import jp.co.kin.business.login.dto.LoginCheckResult;
import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.business.login.service.LoginService;
import jp.co.kin.common.util.BeanUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginUserDataSearchService searchService;

	@Override
	public LoginCheckResult checkLogin(LoginUserDataDto dto) {

		LoginUserDataDto searchDto = searchService.search(dto.getLoginId());
		LoginCheckResult result = new LoginCheckResult();

		if (BeanUtil.isNull(searchDto)) {
			result.setHasError(true);
			result.setMessage("validate.login.loginIdNoExist");
		} else if (!searchDto.getPassword().equals(dto.getPassword())) {
			result.setHasError(true);
			result.setMessage("validate.login.inValidPassword");
		}

		return result;
	}

}
