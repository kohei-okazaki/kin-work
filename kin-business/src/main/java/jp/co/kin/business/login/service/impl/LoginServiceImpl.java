package jp.co.kin.business.login.service.impl;

import org.springframework.stereotype.Service;

import jp.co.kin.business.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public String check(String name) {
		test();
		return "gaebawtw";
	}

	private void test() {

	}

	@Override
	public void testService() {

	}

}
