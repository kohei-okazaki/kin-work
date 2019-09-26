package jp.co.kin.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.method.HandlerMethod;

import jp.co.kin.common.encode.BaseEncodeAndDecoder;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.log.MDC;
import jp.co.kin.common.type.Charset;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.LocalDateTimeUtil;

public class RequestInterceptor extends BaseWebInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(RequestInterceptor.class);

	@Autowired
	@Qualifier("sha256HashEncodeAndDecoder")
	private BaseEncodeAndDecoder hashCreator;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (isStaticResource(handler)) {
			// 静的リソースの場合は認証不要
			return true;
		}
		// MDCの設定を行う
		MDC.put("id", hashCreator.encode(LocalDateTimeUtil.toString(LocalDateTimeUtil.getSysDate(),
				DateFormatType.YYYYMMDD_HHMMSS_NOSEP), Charset.UTF_8));

		Method method = ((HandlerMethod) handler).getMethod();
		LOG.info("---> START " + method.getDeclaringClass().getName() + "#" + method.getName() + "[URI:"
				+ request.getRequestURI() + ",METHOD:" + request.getMethod() + "]");

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e)
			throws Exception {

		if (isStaticResource(handler)) {
			// 静的リソースの場合は認証不要
			return;
		}
		Method method = ((HandlerMethod) handler).getMethod();
		LOG.info("---> END " + method.getDeclaringClass().getName() + "#" + method.getName());

	}
}
