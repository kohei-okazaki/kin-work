package jp.co.kin.dashboard.ontimeregist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.ontime.service.OntimeRegistService;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.dashboard.ontimeregist.form.OntimeRegistForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;
import jp.co.kin.web.interceptor.annotation.CsrfToken;

/**
 * 定時登録画面コントローラ
 *
 * @since 1.0.0
 */
@Controller
@RequestMapping("ontimeregist")
public class OntimeRegistController implements BaseViewController {

	@Autowired
	private OntimeRegistService ontimeRegistService;

	@ModelAttribute("ontimeRegistForm")
	public OntimeRegistForm setUpForm() {
		return new OntimeRegistForm();
	}

	@GetMapping("/input")
	public String input() {
		return getView(DashboardView.ONTIME_REGIST_INPUT);
	}

	@CsrfToken(factocy = true)
	@PostMapping("/confirm")
	public String confirm(@Valid OntimeRegistForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.ONTIME_REGIST_INPUT);
		}

		return getView(DashboardView.ONTIME_REGIST_CONFIRM);
	}

	@CsrfToken(check = true)
	@PostMapping("/complete")
	public String complete(OntimeRegistForm form) {

		OntimeDto dto = DtoFactory.getDto(OntimeDto.class, form);

		ontimeRegistService.regist(dto);

		return getView(DashboardView.ONTIME_REGIST_COMPLETE);
	}
}
