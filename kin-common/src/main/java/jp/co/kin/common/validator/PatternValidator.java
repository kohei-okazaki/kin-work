package jp.co.kin.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validator.annotation.Pattern;

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
		return this.regix.is(value.toString());
	}
}
