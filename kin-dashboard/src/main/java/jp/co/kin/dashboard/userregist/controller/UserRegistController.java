package jp.co.kin.dashboard.userregist.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import jp.co.kin.business.db.search.OntimeMtSearchService;
import jp.co.kin.business.session.annotation.SessionNonAuth;
import jp.co.kin.business.userregist.dto.UserRegistDto;
import jp.co.kin.business.userregist.service.LoginUserRegistService;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.dashboard.userregist.form.UserRegistForm;
import jp.co.kin.web.controller.BaseViewController;
import jp.co.kin.web.interceptor.annotation.CsrfToken;

/**
 * ユーザ登録コントローラ
 *
 */
@Controller
@RequestMapping("userRegist")
public class UserRegistController implements BaseViewController {

	@Autowired
	private LoginUserRegistService loginUserRegistService;
	@Autowired
	private OntimeMtSearchService ontimeMtSearchService;

	@ModelAttribute("userRegistForm")
	public UserRegistForm setUpForm() {
		return new UserRegistForm();
	}

	@SessionNonAuth
	@GetMapping("/input")
	public String input(Model model) {
		// 定時情報マスタから企業コードを取得
		List<String> companyCodeList = ontimeMtSearchService.search().stream().map(e -> e.getCompanyCode())
				.collect(Collectors.toList());
		model.addAttribute("companyCodeList", companyCodeList);
		return getView(DashboardView.USER_REGIST_INPUT);
	}

	@SessionNonAuth
	@CsrfToken(factocy = true)
	@PostMapping("/confirm")
	public String confirm(Model model, HttpServletRequest request, @Valid UserRegistForm form,
			BindingResult result) {

		// 定時情報を取得
		List<String> companyCodeList = ontimeMtSearchService.search().stream().map(e -> e.getCompanyCode())
				.collect(Collectors.toList());
		model.addAttribute("companyCodeList", companyCodeList);
		model.addAttribute("selectedCompanyCode", form.getCompanyCode());

		if (result.hasErrors()) {
			return getView(DashboardView.USER_REGIST_INPUT);
		}

		UserRegistDto dto = DtoFactory.getDto(UserRegistDto.class, form);
		if (loginUserRegistService.isDuplicateLoginId(dto)) {
			model.addAttribute("errorMessage", "指定されたログインIDは使用できません");
			return getView(DashboardView.USER_REGIST_INPUT);
		}

		return getView(DashboardView.USER_REGIST_CONFIRM);
	}

	@SessionNonAuth
	@CsrfToken(check = true)
	@PostMapping("/complete")
	public String complete(Model model, UserRegistForm form) {

		UserRegistDto dto = DtoFactory.getDto(UserRegistDto.class, form);
		loginUserRegistService.regist(dto);

		return getView(DashboardView.USER_REGIST_COMPLETE);
	}

}
