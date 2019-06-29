package jp.co.kin.dashboard.attendRegist.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kin.dashboard.attendRegist.form.AttendReigstForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

@Controller
@RequestMapping("attendRegist")
public class AttendRegistController implements BaseViewController {

	@ModelAttribute("attendRegistForm")
	public AttendReigstForm setUpForm() {
		return new AttendReigstForm();
	}

	@GetMapping("/input")
	public String index(Model model) {
		return getView(DashboardView.ATTEND_REGIST_INPUT);
	}

	@PostMapping("/confirm")
	public String confirm(Model model, @Valid AttendReigstForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.ATTEND_REGIST_INPUT);
		}

		return getView(DashboardView.ATTEND_REGIST_CONFIRM);
	}

	@PostMapping("/complete")
	public String complete() {
		return getView(DashboardView.ATTEND_REGIST_COMPLETE);
	}
}
