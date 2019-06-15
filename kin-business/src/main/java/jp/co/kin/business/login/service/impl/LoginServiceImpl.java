package jp.co.kin.business.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.login.service.LoginService;
import jp.co.kin.db.dao.LoginUserDataDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginUserDataDao dao;

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
