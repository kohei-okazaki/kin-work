package jp.co.kin.common.validator.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.kin.common.validator.MinValidator;

/**
 * 最小値チェックのアノテーション
 *
 * @since 1.0.0
 *
 */
@Inherited
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = MinValidator.class)
public @interface Min {

    /** size */
    int size();

    /** 同じ値を含むか */
    boolean isEqual() default true;

    /** message */
    String message() default "{0}は桁数が足りません";

    /** groups */
    Class<?>[] groups() default {};

    /** payload */
    Class<? extends Payload>[] payload() default {};
}
