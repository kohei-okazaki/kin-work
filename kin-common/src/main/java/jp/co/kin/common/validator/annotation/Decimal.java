package jp.co.kin.common.validator.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.kin.common.validator.DecimalValidator;

@Inherited
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = DecimalValidator.class)
public @interface Decimal {

	int min() default 1;

	int max() default 99999;

	boolean minEqual() default true;

	boolean maxEqual() default true;

	/** message */
	String message() default "";

	/** groups */
	Class<?>[] groups() default {};

	/** payload */
	Class<? extends Payload>[] payload() default {};
}
