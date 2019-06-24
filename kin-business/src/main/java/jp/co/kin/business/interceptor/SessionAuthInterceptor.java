package jp.co.kin.business.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import jp.co.kin.business.login.dto.LoginCheckResult;
import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.business.login.service.LoginService;
import jp.co.kin.business.session.SessionLoginUser;
import jp.co.kin.business.session.annotation.SessionNonAuth;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.common.context.SessionComponent;
import jp.co.kin.common.exception.CommonErrorCode;
import jp.co.kin.common.exception.SystemException;
import jp.co.kin.web.iterceptor.BaseWebInterceptor;

public class SessionAuthInterceptor extends BaseWebInterceptor {

	@Autowired
	private SessionComponent sessionComponent;
	@Autowired
	private LoginService loginService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (isStaticResource(handler)) {
			// 静的リソースの場合は認証不要
			return true;
		} else if (isSessionAuth(handler)) {
			// session情報の検査が必要な場合

			// session情報を取得
			HttpSession session = request.getSession();
			SessionLoginUser sessionLoginUser = sessionComponent
					.getValue(session, "sessionUser", SessionLoginUser.class).orElseThrow(
							() -> new SystemException(CommonErrorCode.SESSION_ILLEGAL, "session情報が不正です"));

			LoginUserDataDto dto = DtoFactory.getNullableDto(LoginUserDataDto.class, sessionLoginUser)
					.orElseThrow(
							() -> new SystemException(CommonErrorCode.SESSION_ILLEGAL, "session情報が不正です"));

			// session情報がログイン基準を満たしているか検証
			LoginCheckResult result = loginService.checkLogin(dto);
			if (result.hasError()) {
				throw new SystemException(CommonErrorCode.SESSION_ILLEGAL,
						"session情報が不正です loginId:" + dto.getLoginId());
			}
		}

		return true;
	}

	private boolean isSessionAuth(Object handler) {
		return !((HandlerMethod) handler).getMethod().isAnnotationPresent(SessionNonAuth.class);
	}

}
