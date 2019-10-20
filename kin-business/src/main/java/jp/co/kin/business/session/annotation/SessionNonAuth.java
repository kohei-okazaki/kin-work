package jp.co.kin.business.session.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * session情報のチェックを行わないことを示すマーカーアノテーション
 *
 * @since 1.0.0
 *
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface SessionNonAuth {

}
