package jp.co.kin.business.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.kin.web.iterceptor.BaseWebInterceptor;

public class SessionAuthInterceptor extends BaseWebInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (isStaticResource(handler)) {
			// 静的リソースの場合は認証不要
			return true;
		}

		HttpSession session = request.getSession();

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws Exception {

		if (isStaticResource(handler)) {
			// 静的リソースの場合は認証不要
			return;
		}

	}

}
