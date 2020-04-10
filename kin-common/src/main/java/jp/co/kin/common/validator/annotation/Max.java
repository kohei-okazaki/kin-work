package jp.co.kin.common.validator.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.kin.common.validator.MaxValidator;

/**
 * 最大値チェックのアノテーション
 *
 * @since 1.0.0
 *
 */
@Inherited
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = MaxValidator.class)
public @interface Max {

    /** size */
    int size();

    /** 同じ値を含むか */
    boolean isEqual() default true;

    /** message */
    String message() default "{0}は桁数超過しています";

    /** groups */
    Class<?>[] groups() default {};

    /** payload */
    Class<? extends Payload>[] payload() default {};
}
