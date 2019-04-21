package jp.co.kin.common.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validate.annotation.Required;

public class RequiredValidator implements ConstraintValidator<Required, Object> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (BeanUtil.isNull(value)) {
			return false;
		}
		return !StringUtil.isEmpty(value.toString());
	}
}