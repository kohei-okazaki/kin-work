package jp.co.kin.business.db.update.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.update.LoginUserDataUpdateService;
import jp.co.kin.db.dao.LoginUserDataDao;
import jp.co.kin.db.entity.LoginUserData;

@Service
public class LoginUserDataUpdateServiceImpl implements LoginUserDataUpdateService {

	@Autowired
	private LoginUserDataDao dao;

	@Override
	public void updateFailCount(LoginUserData entity) {
		dao.updateFailCount(entity);
	}

	@Override
	public void updateAccountLock(LoginUserData entity) {
		dao.updateAccountLock(entity);
	}

}
