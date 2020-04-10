package jp.co.kin.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validator.annotation.Pattern;

/**
 * 文字種の妥当性チェッククラス
 *
 * @since 1.0.0
 *
 */
public class PatternValidator implements ConstraintValidator<Pattern, Object> {

    /** 正規表現の列挙 */
    private RegixType regix;

    @Override
    public void initialize(Pattern annotation) {
        this.regix = annotation.regixPattern();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (BeanUtil.isNull(value) || StringUtil.isEmpty(value.toString())) {
            return true;
        }
        return value.toString().matches(this.regix.getValue());
    }
}
