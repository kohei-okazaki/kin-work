package jp.co.kin.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validator.annotation.Min;

/**
 * 最小値の妥当性チェッククラス
 *
 * @since 1.0.0
 *
 */
public class MinValidator implements ConstraintValidator<Min, Object> {

    private int size;

    private boolean isEqual;

    @Override
    public void initialize(Min annotation) {
        this.size = annotation.size();
        this.isEqual = annotation.isEqual();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (BeanUtil.isNull(value) || StringUtil.isEmpty(value.toString())) {
            return true;
        }
        if (isEqual) {
            return this.size <= value.toString().length();
        }
        return this.size < value.toString().length();
    }
}
