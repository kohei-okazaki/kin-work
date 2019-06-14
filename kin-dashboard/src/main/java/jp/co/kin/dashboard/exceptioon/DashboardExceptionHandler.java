package jp.co.kin.dashboard.exceptioon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import jp.co.kin.common.exception.BaseExceptionHander;

@Component
public class DashboardExceptionHandler extends BaseExceptionHander {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception e) {

		ModelAndView modelView = new ModelAndView();
		// error画面を設定
		modelView.setViewName(null);

		return modelView;
	}
}
