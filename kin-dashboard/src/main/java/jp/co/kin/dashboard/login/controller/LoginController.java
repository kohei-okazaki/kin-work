package jp.co.kin.dashboard.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kin.business.login.dto.LoginCheckResult;
import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.business.login.service.LoginService;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.common.context.MessageSourceComponent;
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
	@Autowired
	private MessageSourceComponent messageSourceComponnt;

	@ModelAttribute("loginForm")
	public LoginForm setUpForm() {
		return new LoginForm();
	}

	@GetMapping("/index")
	public String index() {
		return getView(DashboardView.LOGIN);
	}

	@PostMapping("/top")
	public String top(Model model, HttpServletRequest request, @Valid LoginForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.LOGIN);
		}

		LoginUserDataDto dto = DtoFactory.getDto(LoginUserDataDto.class, form);

		LoginCheckResult loginCheckResult = loginService.checkLogin(dto);
		if (loginCheckResult.hasError()) {
			String message = messageSourceComponnt.getMessage(loginCheckResult.getMessage());
			model.addAttribute("errorMessage", message);
			return getView(DashboardView.LOGIN);
		}

		sessionComponent.setValue(request.getSession(), "sessionUser", dto.getSessionLoginUser());

		return getView(DashboardView.TOP);
	}

	@GetMapping("/top")
	public String top(HttpServletRequest request) {
		return getView(DashboardView.TOP);
	}
}
