package jp.co.kin.dashboard.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.business.login.service.LoginService;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.common.context.SessionComponent;
import jp.co.kin.dashboard.login.form.LoginForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

/**
 * ログインコントローラ
 */
@Controller
@RequestMapping("login")
public class LoginController implements BaseViewController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private SessionComponent sessionComponent;

	/**
	 * Formを返す
	 *
	 * @return LoginForm
	 */
	@ModelAttribute("loginForm")
	public LoginForm setUpForm() {
		return new LoginForm();
	}

	@GetMapping("/index")
	public String index() {
		return getView(DashboardView.LOGIN);
	}

	@PostMapping("/top")
	public String top(HttpServletRequest request, @Valid LoginForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.LOGIN);
		}

		LoginUserDataDto dto = DtoFactory.getDto(LoginUserDataDto.class, form);

		loginService.checkLogin(dto);

		sessionComponent.setValue(request.getSession(), "sessionUser", dto.getSessionLoginUser());

		return getView(DashboardView.TOP);
	}
}
