package jp.co.kin.common.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validate.annotation.Length;

public class LengthValidator implements ConstraintValidator<Length, Object> {

	/** length */
	private int length;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(Length annotation) {
		this.length = annotation.length();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (BeanUtil.isNull(value) || StringUtil.isEmpty(value.toString())) {
			 return true;
		}
		return value.toString().length() == length;
	}
}