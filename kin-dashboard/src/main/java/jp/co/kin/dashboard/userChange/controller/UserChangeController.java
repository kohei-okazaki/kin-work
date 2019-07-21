package jp.co.kin.dashboard.userChange.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.dashboard.userChange.form.UserChangeForm;
import jp.co.kin.web.controller.BaseViewController;

/**
 * ユーザ設定変更コントローラ
 *
 */
@Controller
@RequestMapping("userChange")
public class UserChangeController implements BaseViewController {

	@ModelAttribute("userChangeForm")
	public UserChangeForm setUpForm() {
		return new UserChangeForm();
	}

	@GetMapping("/input")
	public String input() {
		return getView(DashboardView.USER_CHANGE_INPUT);
	}

	@PostMapping("/confirm")
	public String confirm(Model model, @Valid UserChangeForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.USER_CHANGE_INPUT);
		}
		return getView(DashboardView.USER_CHANGE_CONFIRM);
	}

	@PostMapping("/complete")
	public String complete(UserChangeForm form) {
		return getView(DashboardView.USER_CHANGE_COMPLETE);
	}
}
