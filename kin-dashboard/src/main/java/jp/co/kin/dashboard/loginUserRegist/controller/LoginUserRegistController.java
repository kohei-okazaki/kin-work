package jp.co.kin.dashboard.loginUserRegist.controller;

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

import jp.co.kin.business.loginUserRegist.dto.LoginUserRegistDto;
import jp.co.kin.business.loginUserRegist.service.LoginUserRegistService;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.dashboard.loginUserRegist.form.LoginUserRegistForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

/**
 * ログインユーザ登録コントローラ
 *
 */
@Controller
@RequestMapping("loginUserRegist")
public class LoginUserRegistController implements BaseViewController {

	@Autowired
	private LoginUserRegistService loginUserRegistService;

	@ModelAttribute("loginUserRegistForm")
	public LoginUserRegistForm setUpForm() {
		return new LoginUserRegistForm();
	}

	@GetMapping("/input")
	public String input() {
		return getView(DashboardView.USER_REGIST_INPUT);
	}

	@PostMapping("/confirm")
	public String confirm(Model model, HttpServletRequest request, @Valid LoginUserRegistForm form,
			BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.USER_REGIST_INPUT);
		}

		LoginUserRegistDto dto = DtoFactory.getDto(LoginUserRegistDto.class, form);
		loginUserRegistService.regist(dto);

		return getView(DashboardView.USER_REGIST_CONFIRM);
	}

	@PostMapping("/complete")
	public String complete(Model model, @Valid LoginUserRegistForm form, BindingResult result) {
		return getView(DashboardView.USER_REGIST_COMPLETE);
	}

}
