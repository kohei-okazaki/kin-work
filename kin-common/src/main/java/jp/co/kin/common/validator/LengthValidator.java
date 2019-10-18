package jp.co.kin.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.common.validator.annotation.Length;

/**
 * 桁数の妥当性チェッククラス
 *
 * @since 1.0.0
 *
 */
public class LengthValidator implements ConstraintValidator<Length, Object> {

	/** length */
	private int length;

	@Override
	public void initialize(Length annotation) {
		this.length = annotation.length();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (BeanUtil.isNull(value) || StringUtil.isEmpty(value.toString())) {
			return true;
		}
		return value.toString().length() == length;
	}

}
