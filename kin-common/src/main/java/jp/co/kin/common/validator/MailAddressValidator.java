package jp.co.kin.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validator.annotation.MailAddress;

/**
 * メールアドレスの妥当性チェッククラス
 *
 * @since 1.0.0
 *
 */
public class MailAddressValidator implements ConstraintValidator<MailAddress, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (BeanUtil.isNull(value) || StringUtil.isEmpty(value.toString())) {
            return true;
        }
        return value.toString().matches(RegixType.MAIL_ADDRESS.getValue());
    }

}
