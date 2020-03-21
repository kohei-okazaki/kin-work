package jp.co.kin.common.io.file.csv.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * CSVの1レコードのBeanに付与するマーカーアノテーション
 *
 * @since 1.0.0
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface CsvEntity {

}
