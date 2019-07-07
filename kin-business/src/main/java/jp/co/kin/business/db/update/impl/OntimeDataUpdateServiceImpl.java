package jp.co.kin.business.db.update.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.update.OntimeDataUpdateService;
import jp.co.kin.db.dao.UserOntimeDataDao;
import jp.co.kin.db.entity.UserOntimeData;

@Service
public class OntimeDataUpdateServiceImpl implements OntimeDataUpdateService {

	@Autowired
	private UserOntimeDataDao dao;

	@Override
	public void update(UserOntimeData entity) {
		dao.update(entity);
	}

}
