package jp.co.kin.common.validator.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.kin.common.validator.MailAddressValidator;

@Inherited
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = MailAddressValidator.class)
public @interface MailAddress {

	/** message */
	String message() default "";

	/** groups */
	Class<?>[] groups() default {};

	/** payload */
	Class<? extends Payload>[] payload() default {};
}
