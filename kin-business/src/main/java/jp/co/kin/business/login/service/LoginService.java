package jp.co.kin.business.login.service;

import jp.co.kin.business.login.dto.LoginCheckResult;
import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.web.service.BaseService;

/**
 * ログイン処理サービスインターフェース
 *
 * @since 1.0.0
 */
public interface LoginService extends BaseService {

    /**
     * ログインユーザ情報のログインチェックを行う
     *
     * @param dto
     *     ログインユーザのDTO
     * @return LoginCheckResult
     */
    LoginCheckResult checkLogin(LoginUserDataDto dto);

    /**
     * ログイン失敗回数をインクリメントし、更新後のログイン失敗回数が3回目の場合、アカウントロックフラグを1に更新する
     *
     * @param dto
     *     ログインユーザのDTO
     */
    void updateFailLoginUserData(LoginUserDataDto dto);

    /**
     * ログイン失敗回数を"0"に更新する
     *
     * @param dto
     *     ログインユーザのDTO
     */
    void updateClearloginFailCount(LoginUserDataDto dto);
}
