package jp.co.kin.business.db.create.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.OntimeDataCreateService;
import jp.co.kin.db.dao.UserOntimeDataDao;
import jp.co.kin.db.entity.UserOntimeData;

@Service
public class OntimeDataCreateServiceImpl implements OntimeDataCreateService {

	@Autowired
	private UserOntimeDataDao dao;

	@Override
	public void create(UserOntimeData entity) {
		dao.insert(entity);
	}

}
