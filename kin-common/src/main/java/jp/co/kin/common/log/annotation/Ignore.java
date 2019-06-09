package jp.co.kin.common.log.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * ログ出力非対象項目につけるマーカーアノテーション
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface Ignore {

}
