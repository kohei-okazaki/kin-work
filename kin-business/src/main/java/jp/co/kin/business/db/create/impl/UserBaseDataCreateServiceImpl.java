package jp.co.kin.business.db.create.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.UserBaseDataCreateService;
import jp.co.kin.db.dao.UserBaseDataDao;
import jp.co.kin.db.entity.UserBaseData;

/**
 * ユーザ基本情報作成サービス実装クラス
 *
 * @since 1.0.0
 */
@Service
public class UserBaseDataCreateServiceImpl implements UserBaseDataCreateService {

    @Autowired
    private UserBaseDataDao dao;

    @Override
    public void create(UserBaseData entity) {
        dao.insert(entity);
    }

}
