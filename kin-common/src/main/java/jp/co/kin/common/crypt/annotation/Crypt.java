package jp.co.kin.common.crypt.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 暗号化されたフィールドであることを示すマーカーアノテーション
 *
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface Crypt {

}
