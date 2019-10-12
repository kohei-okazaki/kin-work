package jp.co.kin.business.db.update.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.update.UserBaseDataUpdateService;
import jp.co.kin.db.dao.UserBaseDataDao;

@Service
public class UserBaseDataUpdateServiceImpl implements UserBaseDataUpdateService {

	@Autowired
	private UserBaseDataDao dao;
}
