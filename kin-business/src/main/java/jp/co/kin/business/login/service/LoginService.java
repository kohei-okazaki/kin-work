package jp.co.kin.business.login.service;

import jp.co.kin.web.service.BaseService;

public interface LoginService extends BaseService {

	String check(String name);

	void testService();
}
