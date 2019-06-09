package jp.co.kin.dashboard.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kin.dashboard.login.form.LoginForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

/**
 * ログインコントローラ
 */
@Controller
@RequestMapping("login")
public class LoginController implements BaseViewController {

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
}
