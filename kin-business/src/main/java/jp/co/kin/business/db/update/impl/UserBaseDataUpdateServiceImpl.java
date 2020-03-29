package jp.co.kin.business.db.update.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.update.UserBaseDataUpdateService;
import jp.co.kin.db.dao.UserBaseDataDao;
import jp.co.kin.db.entity.UserBaseData;

/**
 * ユーザ基本情報更新サービス実装クラス
 *
 * @since 1.0.0
 */
@Service
public class UserBaseDataUpdateServiceImpl implements UserBaseDataUpdateService {

    @Autowired
    private UserBaseDataDao dao;

    @Override
    public void update(UserBaseData entity) {
        dao.update(entity);
    }
}
