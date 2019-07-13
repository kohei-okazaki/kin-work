package jp.co.kin.business.db.create.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.UserBaseDataCreateService;
import jp.co.kin.db.dao.UserBaseDataDao;
import jp.co.kin.db.entity.UserBaseData;

@Service
public class UserBaseDataCreateServiceImpl implements UserBaseDataCreateService {

	@Autowired
	private UserBaseDataDao dao;

	@Override
	public void create(UserBaseData entity) {
		dao.insert(entity);
	}

}
