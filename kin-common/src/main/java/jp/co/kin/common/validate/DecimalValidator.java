package jp.co.kin.common.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validate.annotation.Decimal;

public class DecimalValidator implements ConstraintValidator<Decimal, Object> {

	/** 最小桁数 */
	private int min;
	/** 最大桁数 */
	private int max;
	/** 最小桁数で同値含むか */
	private boolean minEqual;
	/** 最大桁数で同値含むか */
	private boolean maxEqual;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(Decimal annotation) {
		this.min = annotation.min();
		this.max = annotation.max();
		this.minEqual = annotation.minEqual();
		this.maxEqual = annotation.maxEqual();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (BeanUtil.isNull(value) || StringUtil.isEmpty(value.toString())) {
			return true;
		}
		if (RegixType.DECIMAL.is(value.toString())) {
			int length = value.toString().replaceAll(".", "").length();
			if (minEqual && maxEqual) {
				return (min <= length) && (length <= max);
			} else if (minEqual) {
				return (min <= length) && (length < max);
			} else if (maxEqual) {
				return (min < length) && (length <= max);
			} else {
				return (min < length) && (length < max);
			}
		} else {
			return false;
		}
	}
}