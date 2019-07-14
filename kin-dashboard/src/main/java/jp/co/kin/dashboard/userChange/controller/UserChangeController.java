package jp.co.kin.dashboard.userChange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
