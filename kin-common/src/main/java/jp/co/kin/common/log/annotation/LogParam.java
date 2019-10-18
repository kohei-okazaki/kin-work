package jp.co.kin.common.log.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * ログ出力項目名につけるアノテーション<br>
 * ログ出力時に指定したい名前をnameに指定する
 * 
 * @since 1.0.0
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface LogParam {

	/**
	 * 名前
	 *
	 * @return 名前
	 */
	String name();

}
