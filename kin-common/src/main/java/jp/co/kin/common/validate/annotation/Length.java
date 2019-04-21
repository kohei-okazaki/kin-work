package jp.co.kin.common.validate.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.kin.common.validate.LengthValidator;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = LengthValidator.class)
public @interface Length {

	/** length */
	int length();

	/** message */
	String message() default "";

	/** groups */
	Class<?>[] groups() default {};

	/** payload */
	Class<? extends Payload>[] payload() default {};
}
