package jp.co.kin.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.kin.common.context.SessionComponent;
import jp.co.kin.common.encode.BaseEncodeAndDecoder;
import jp.co.kin.common.exception.CommonErrorCode;
import jp.co.kin.common.exception.SystemException;
import jp.co.kin.common.type.Charset;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.web.interceptor.annotation.CsrfToken;

/**
 * CSRF検証インターセプター
 * 
 * @since 1.0.0
 *
 */
public class CsrfTokenInterceptor extends BaseWebInterceptor {

	@Autowired
	private SessionComponent sessionComponent;
	@Autowired
	@Qualifier("sha256HashEncodeAndDecoder")
	private BaseEncodeAndDecoder encoder;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (isStaticResource(handler)) {
			// 静的リソースの場合は認証不要
			return true;
		}

		if (isCsrfTokenCheck(handler)) {
			// CSRFトークンチェックを行う
			String sessionCsrfToken = sessionComponent
					.getValue(request.getSession(), "csrfToken", String.class).orElseThrow(
							() -> new SystemException(CommonErrorCode.SESSION_ILLEGAL, "session情報が不正です"));

			if (StringUtil.isEmpty(sessionCsrfToken)) {
				throw new SystemException(CommonErrorCode.SESSION_ILLEGAL, "session情報が不正です");
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (isStaticResource(handler)) {
			// 静的リソースの場合は認証不要
			return;
		}

		if (isCsrfTokenCheck(handler)) {
			// CSRFトークンチェック後、トークンを削除する
			sessionComponent.removeValue(request.getSession(), "csrfToken");
		}

		if (isCsrfTokenFactory(handler)) {
			// CSRFトークンを作成する
			String random = StringUtil.getRandamStr(16);
			String csrfToken = encoder.encode(random, Charset.UTF_8);

			sessionComponent.setValue(request.getSession(), "csrfToken", csrfToken);
		}
	}

	/**
	 * CSRFチェックを行うかどうかを返す
	 *
	 * @param handler
	 *            ハンドラー
	 * @return 判定結果
	 */
	private boolean isCsrfTokenCheck(Object handler) {
		CsrfToken csrfToken = ((HandlerMethod) handler).getMethod().getAnnotation(CsrfToken.class);
		if (BeanUtil.isNull(csrfToken)) {
			return false;
		}
		return csrfToken.check();
	}

	/**
	 * CSRFトークンを作成するかどうかを返す
	 *
	 * @param handler
	 *            ハンドラー
	 * @return 判定結果
	 */
	private boolean isCsrfTokenFactory(Object handler) {
		CsrfToken csrfToken = ((HandlerMethod) handler).getMethod().getAnnotation(CsrfToken.class);
		if (BeanUtil.isNull(csrfToken)) {
			return false;
		}
		return csrfToken.factocy();
	}
}
