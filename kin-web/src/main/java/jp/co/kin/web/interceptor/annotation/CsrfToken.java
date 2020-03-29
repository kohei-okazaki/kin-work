package jp.co.kin.web.interceptor.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jp.co.kin.web.interceptor.CsrfTokenInterceptor;

/**
 * CSRFトークンをチェックすることを示すアノテーション
 * <ul>
 * <li>トークンを生成したいメソッドに<code>@CsrfToken(factocy = true)</code>を付与</li>
 * <li>トークンチェックを行いたいメソッドに<code>@CsrfToken(check = true)</code>を付与</li>
 * </ul>
 *
 * @see CsrfTokenInterceptor
 * @since 1.0.0
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface CsrfToken {

    /**
     * トークンを生成する
     *
     * @return 生成する場合true、それ以外の場合false
     */
    boolean factocy() default false;

    /**
     * トークンをチェックする
     *
     * @return チェックする場合true、それ以外の場合false
     */
    boolean check() default false;
}
