package jp.co.kin.business.db.search.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.search.UserBaseDataSearchService;
import jp.co.kin.business.userregist.dto.UserBaseDataDto;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.db.dao.UserBaseDataDao;
import jp.co.kin.db.entity.UserBaseData;

/**
 * ユーザ基本情報検索サービス実装クラス
 *
 * @since 1.0.0
 */
@Service
public class UserBaseDataSearchServiceImpl implements UserBaseDataSearchService {

    @Autowired
    private UserBaseDataDao userBaseDataDao;

    @Override
    public UserBaseDataDto searchByUserId(String userId) {
        UserBaseData entity = userBaseDataDao.selectById(userId);
        return DtoFactory.getDto(UserBaseDataDto.class, entity);
    }

}
