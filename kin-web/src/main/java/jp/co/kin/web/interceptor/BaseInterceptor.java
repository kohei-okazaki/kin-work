package jp.co.kin.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 * 基底Interceptorインターフェース
 *
 */
public interface BaseInterceptor extends HandlerInterceptor {

	public default boolean isStaticResource(Object o) {
		return o instanceof ResourceHttpRequestHandler;
	}
}
