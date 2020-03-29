package jp.co.kin.business.userregist.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.LoginUserDataCreateService;
import jp.co.kin.business.db.create.UserBaseDataCreateService;
import jp.co.kin.business.db.search.LoginUserDataSearchService;
import jp.co.kin.business.login.type.AccountLockFlg;
import jp.co.kin.business.userregist.dto.UserBusinessProperties;
import jp.co.kin.business.userregist.dto.UserRegistDto;
import jp.co.kin.business.userregist.service.LoginUserRegistService;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.db.entity.LoginUserData;
import jp.co.kin.db.entity.UserBaseData;

/**
 * ログインユーザ登録サービス実装クラス
 *
 * @since 1.0.0
 *
 */
@Service
public class LoginUserRegistServiceImpl implements LoginUserRegistService {

    /** ログインユーザ情報作成サービス */
    @Autowired
    private LoginUserDataCreateService loginUserDataCreateService;
    /** ユーザ業務設定ファイルのDto */
    @Autowired
    private UserBusinessProperties loginUserBusinessProperties;
    /** ログインユーザ情報検索サービス */
    @Autowired
    private LoginUserDataSearchService loginUserDataSearchService;
    /** ユーザ基本情報作成サービス */
    @Autowired
    private UserBaseDataCreateService userBaseDataCreateService;

    @Override
    public void regist(UserRegistDto dto) {

        registLoginUserData(dto);
        registUserBaseData(dto);
        dto.setRegistSuccess(true);
    }

    @Override
    public boolean isDuplicateLoginId(UserRegistDto dto) {
        return loginUserDataSearchService.searchCountByLoginId(dto.getLoginId()) > 1;
    }

    /**
     * ログインユーザ情報を登録
     *
     * @param dto
     *     ユーザ登録DTO
     */
    private void registLoginUserData(UserRegistDto dto) {

        LoginUserData entity = new LoginUserData();

        dto.setUserId("KC" + dto.getLoginId());
        BeanUtil.copy(dto, entity);

        entity.setPasswordExpire(loginUserBusinessProperties.getAuthDate());
        entity.setUserAuth(loginUserBusinessProperties.getUserAuth().getValue());
        entity.setAccountLockFlg(AccountLockFlg.USABLE.getValue());
        entity.setLoginFailCount(BigDecimal.ZERO);

        loginUserDataCreateService.create(entity);
    }

    /**
     * ユーザ基本情報を登録
     *
     * @param dto
     *     ユーザ登録DTO
     */
    private void registUserBaseData(UserRegistDto dto) {

        UserBaseData entity = new UserBaseData();
        BeanUtil.copy(dto, entity);
        userBaseDataCreateService.create(entity);
    }

}
