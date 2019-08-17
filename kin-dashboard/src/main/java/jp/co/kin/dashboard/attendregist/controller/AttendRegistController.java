package jp.co.kin.dashboard.attendregist.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

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

import jp.co.kin.business.attendregist.dto.AttendRegistDto;
import jp.co.kin.business.attendregist.service.AttendRegistService;
import jp.co.kin.business.session.SessionLoginUser;
import jp.co.kin.business.session.annotation.CsrfToken;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.common.context.SessionComponent;
import jp.co.kin.common.exception.BaseException;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.LocalDateTimeUtil;
import jp.co.kin.dashboard.attendregist.form.AttendRegistForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

/**
 * 勤怠登録画面コントローラ
 *
 */
@Controller
@RequestMapping("attendRegist")
public class AttendRegistController implements BaseViewController {

	@Autowired
	private SessionComponent sessionComponent;
	@Autowired
	private AttendRegistService attendRegistService;

	@ModelAttribute("attendRegistForm")
	public AttendRegistForm setUpForm() {
		return new AttendRegistForm();
	}

	@GetMapping("/input")
	public String input(Model model, HttpServletRequest request) {
		initCalendar(model, request);
		return getView(DashboardView.ATTEND_REGIST_INPUT);
	}

	@GetMapping("/changeCalendar")
	public String changeCalendar(Model model, HttpServletRequest request, @Valid AttendRegistForm form,
			BindingResult result) throws BaseException {

		if (result.hasErrors()) {
			initCalendar(model, request);
			return getView(DashboardView.ATTEND_REGIST_INPUT);
		}

		String year = form.getYear();
		String month = form.getMonth();
		LocalDate targetDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
		this.viewCalendar(model, request, new BigDecimal(year), new BigDecimal(month), targetDate);

		return getView(DashboardView.ATTEND_REGIST_INPUT);
	}

	@CsrfToken(factocy = true)
	@PostMapping("/confirm")
	public String confirm(Model model, @Valid AttendRegistForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getRedirectView(DashboardView.ATTEND_REGIST_INPUT);
		}

		return getView(DashboardView.ATTEND_REGIST_CONFIRM);
	}

	@CsrfToken(check = true)
	@PostMapping("/complete")
	public String complete(Model model, AttendRegistForm form) {

		// 勤怠登録formをdtoに変換する
		AttendRegistDto dto = DtoFactory.getDto(AttendRegistDto.class, form);
		attendRegistService.registDailyWorkData(dto);
		return getView(DashboardView.ATTEND_REGIST_COMPLETE);
	}

	/**
	 * カレンダー情報をModelに表示させる
	 *
	 * @param model
	 *            Model
	 * @param request
	 *            HttpServletRequest
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param targetDate
	 *            対象日時
	 */
	private void viewCalendar(Model model, HttpServletRequest request, BigDecimal year, BigDecimal month,
			LocalDate targetDate) {
		model.addAttribute("selectedYear", year);
		model.addAttribute("yearList", attendRegistService.getYearList());
		model.addAttribute("selectedMonth", month);
		model.addAttribute("monthList", attendRegistService.getMonthList());
		model.addAttribute("calendarList", attendRegistService.getBusinessCalendarList(targetDate));
		// 定時情報を設定
		String userId = sessionComponent.getValue(request.getSession(), "sessionUser",
				SessionLoginUser.class).get().getUserId();
		model.addAttribute("ontimeDto", attendRegistService.getOntimeDto(userId));
	}

	/**
	 * システム日時からカレンダー情報を初期化する
	 *
	 * @param model
	 *            Model
	 * @param request
	 *            HttpServletRequest
	 */
	private void initCalendar(Model model, HttpServletRequest request) {
		BigDecimal year = new BigDecimal(
				LocalDateTimeUtil.toString(LocalDateTimeUtil.getSysDate(), DateFormatType.YYYY));
		BigDecimal month = new BigDecimal(
				LocalDateTimeUtil.toString(LocalDateTimeUtil.getSysDate(), DateFormatType.MM));
		LocalDate targetDate = LocalDateTimeUtil.toLocalDate(LocalDateTimeUtil.getSysDate());
		this.viewCalendar(model, request, year, month, targetDate);
	}
}
