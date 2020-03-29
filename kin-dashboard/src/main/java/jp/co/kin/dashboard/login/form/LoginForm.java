package jp.co.kin.dashboard.login.form;

import jp.co.kin.common.log.annotation.Mask;
import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.validator.annotation.Pattern;
import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

/**
 * ログイン画面form
 *
 * @since 1.0.0
 */
public class LoginForm implements BaseForm {

    /** ログインID */
    @Required
    @Pattern(regixPattern = RegixType.HALF_CHAR, message = "ログインIDは半角英数字です")
    private String loginId;
    /** パスワード */
    @Mask
    @Required
    @Pattern(regixPattern = RegixType.HALF_CHAR, message = "パスワードは半角英数字です")
    private String password;

    /**
     * loginIdを返す
     *
     * @return loginId
     *
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * loginIdを設定する
     *
     * @param loginId
     *     loginId
     *
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * passwordを返す
     *
     * @return password
     *
     */
    public String getPassword() {
        return password;
    }

    /**
     * passwordを設定する
     *
     * @param password
     *     password
     *
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
