package jp.co.kin.common.log.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * ログ出力時マスク処理対象項目につけるアノテーション<br>
 * 出力したいマスク文字列をvalueで指定する
 * 
 * @since 1.0.0
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface Mask {

	/**
	 * マスク文字列
	 *
	 * @return value
	 */
	String value() default "****";

}
