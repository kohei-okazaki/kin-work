package jp.co.kin.business.db.create.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.OntimeMtCreateService;
import jp.co.kin.db.dao.OntimeMtDao;
import jp.co.kin.db.entity.OntimeMt;

/**
 * 定時情報マスタ作成サービス実装クラス
 *
 * @since 1.0.0
 */
@Service
public class OntimeMtCreateServiceImpl implements OntimeMtCreateService {

    @Autowired
    private OntimeMtDao dao;

    @Override
    public void create(OntimeMt entity) {
        dao.insert(entity);
    }

}
