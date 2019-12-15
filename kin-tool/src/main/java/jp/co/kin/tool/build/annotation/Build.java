package jp.co.kin.tool.build.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Build
 * 
 * @since 1.0.0
 *
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Build {

}
