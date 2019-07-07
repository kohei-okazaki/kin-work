package jp.co.kin.dashboard.ontimeRegist.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kin.business.session.annotation.CsrfToken;
import jp.co.kin.dashboard.ontimeRegist.form.OntimeRegistForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

/**
 * 定時登録画面コントローラ
 *
 */
@Controller
@RequestMapping("ontimeRegist")
public class OntimeRegistController implements BaseViewController {

	@ModelAttribute("ontimeRegistForm")
	public OntimeRegistForm setUpForm() {
		return new OntimeRegistForm();
	}

	@GetMapping("/input")
	public String input(Model model) {
		return getView(DashboardView.ONTIME_REGIST_INPUT);
	}

	@CsrfToken(factocy = true)
	@PostMapping("/confirm")
	public String confirm(Model model, @Valid OntimeRegistForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.ONTIME_REGIST_INPUT);
		}

		return getView(DashboardView.ONTIME_REGIST_CONFIRM);
	}

	@CsrfToken(check = true)
	@PostMapping("/complete")
	public String complete(Model model, @Valid OntimeRegistForm form) {
		return getView(DashboardView.ONTIME_REGIST_COMPLETE);
	}
}
