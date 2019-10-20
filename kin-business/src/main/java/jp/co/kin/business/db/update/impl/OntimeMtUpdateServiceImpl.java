package jp.co.kin.business.db.update.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.update.OntimeMtUpdateService;
import jp.co.kin.db.dao.OntimeMtDao;
import jp.co.kin.db.entity.OntimeMt;

/**
 * 定時情報マスタ更新サービス実装クラス
 *
 * @since 1.0.0
 *
 */
@Service
public class OntimeMtUpdateServiceImpl implements OntimeMtUpdateService {

	@Autowired
	private OntimeMtDao dao;

	@Override
	public void update(OntimeMt entity) {
		dao.updateEntity(entity);
	}

}
