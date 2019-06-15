package jp.co.kin.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validator.annotation.Max;

public class MaxValidator implements ConstraintValidator<Max, Object> {

	private int size;

	private boolean isEqual;

	@Override
	public void initialize(Max annotation) {
		this.size = annotation.size();
		this.isEqual = annotation.isEqual();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (BeanUtil.isNull(value) || StringUtil.isEmpty(value.toString())) {
			return true;
		}
		if (isEqual) {
			return value.toString().length() <= this.size;
		} else {
			return value.toString().length() < this.size;
		}
	}
}
