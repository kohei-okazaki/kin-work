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
import jp.co.kin.business.session.SessionLoginUser;
import jp.co.kin.business.session.annotation.SessionNonAuth;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.common.context.MessageSourceComponent;
import jp.co.kin.common.context.SessionComponent;
import jp.co.kin.dashboard.login.form.LoginForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

/**
 * ログインコントローラ
 *
 */
@Controller
@RequestMapping("login")
public class LoginController implements BaseViewController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private SessionComponent sessionComponent;
	@Autowired
	private MessageSourceComponent messageSourceComponent;

	@ModelAttribute("loginForm")
	public LoginForm setUpForm() {
		return new LoginForm();
	}

	@SessionNonAuth
	@GetMapping("/index")
	public String index(HttpServletRequest request) {
		sessionComponent.removeValues(request.getSession());
		return getView(DashboardView.LOGIN);
	}

	@SessionNonAuth
	@PostMapping("/top")
	public String top(Model model, HttpServletRequest request, @Valid LoginForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.LOGIN);
		}

		LoginUserDataDto dto = DtoFactory.getDto(LoginUserDataDto.class, form);

		LoginCheckResult loginCheckResult = loginService.checkLogin(dto);
		if (loginCheckResult.hasError()) {

			// ログイン失敗回数をインクリメントし、失敗回数が3回になった場合アカウントをロックする
			loginService.updateFailLoginUserData(dto);

			String message = messageSourceComponent.getMessage(loginCheckResult.getMessage());
			model.addAttribute("errorMessage", message);

			return getView(DashboardView.LOGIN);
		}

		SessionLoginUser sessionUser = DtoFactory.getDto(SessionLoginUser.class, dto);
		sessionComponent.setValue(request.getSession(), "sessionUser", sessionUser);

		return getView(DashboardView.TOP);
	}

	@GetMapping("/top")
	public String top(HttpServletRequest request) {
		return getView(DashboardView.TOP);
	}
}
