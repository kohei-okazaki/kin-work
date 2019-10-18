package jp.co.kin.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validator.annotation.Required;

/**
 * 必須チェックの妥当性チェッククラス
 *
 * @since 1.0.0
 *
 */
public class RequiredValidator implements ConstraintValidator<Required, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (BeanUtil.isNull(value)) {
			return false;
		}
		return !StringUtil.isEmpty(value.toString());
	}
}
