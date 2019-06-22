package jp.co.kin.dashboard.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import jp.co.kin.common.context.MessageSourceComponent;
import jp.co.kin.common.exception.BaseErrorCode;
import jp.co.kin.common.exception.BaseExceptionHander;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.log.type.LogLevel;
import jp.co.kin.dashboard.type.DashboardView;

@Component
public class DashboardExceptionHandler extends BaseExceptionHander {

	private static final Logger LOG = LoggerFactory.getLogger(DashboardExceptionHandler.class);

	@Autowired
	private MessageSourceComponent messageCompenent;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception e) {

		ModelAndView modelView = new ModelAndView();
		// error画面を設定
		modelView.setViewName(DashboardView.ERROR.getName());

		LogLevel loglevel = getLogLevel(e);
		BaseErrorCode errorCode = getErrorCode(e);
		String errorMessage = messageCompenent.getMessage(errorCode.getOuterErrorCode());
		String detail = getDetail(e);

		modelView.addObject("errorMessage", errorMessage);

		if (LogLevel.ERROR == loglevel) {
			LOG.error(detail, e);
		} else {
			LOG.warn(detail, e);
		}

		return modelView;
	}
}
