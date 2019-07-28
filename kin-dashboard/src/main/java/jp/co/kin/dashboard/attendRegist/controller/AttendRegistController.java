package jp.co.kin.dashboard.attendRegist.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

import jp.co.kin.business.attendRegist.dto.AttendBusinessCalendar;
import jp.co.kin.business.attendRegist.service.AttendRegistService;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.session.SessionLoginUser;
import jp.co.kin.business.session.annotation.CsrfToken;
import jp.co.kin.common.context.SessionComponent;
import jp.co.kin.common.exception.BaseException;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.util.LocalDateTimeUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.dashboard.attendRegist.form.AttendRegistForm;
import jp.co.kin.dashboard.exception.DashboardErrorCode;
import jp.co.kin.dashboard.exception.DashboardException;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

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

		LocalDate sysDate = LocalDateTimeUtil.toLocalDate(LocalDateTimeUtil.getSysDate());
		List<AttendBusinessCalendar> calendarList = attendRegistService.getBusinessCalendarList(sysDate);
		model.addAttribute("calendarList", calendarList);

		model.addAttribute("selectedYear",
				new BigDecimal(
						LocalDateTimeUtil.toString(LocalDateTimeUtil.getSysDate(), DateFormatType.YYYY)));
		model.addAttribute("yearList", attendRegistService.getYearList());

		model.addAttribute("selectedMonth",
				new BigDecimal(
						LocalDateTimeUtil.toString(LocalDateTimeUtil.getSysDate(), DateFormatType.MM)));
		model.addAttribute("monthList", attendRegistService.getMonthList());

		// 定時情報を取得する
		String userId = sessionComponent.getValue(request.getSession(), "sessionUser",
				SessionLoginUser.class).get().getUserId();
		OntimeDto ontimeDto = attendRegistService.getOntimeDto(userId);
		model.addAttribute("ontimeDto", ontimeDto);

		return getView(DashboardView.ATTEND_REGIST_INPUT);
	}

	@GetMapping("/changeCalendar")
	public String changeCalendar(Model model, HttpServletRequest request) throws BaseException {

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		if (StringUtil.isEmpty(year) || StringUtil.isEmpty(month)) {
			throw new DashboardException(DashboardErrorCode.ILLEGAL_REQUEST,
					"リクエスト情報が不正です. year=" + year + ", month=" + month);
		} else if (!year.matches(RegixType.HALF_NUMBER.getValue())
				|| !month.matches(RegixType.HALF_NUMBER.getValue())) {
			throw new DashboardException(DashboardErrorCode.ILLEGAL_REQUEST,
					"yearまたはmonthが半角数字でありません. year=" + year + ", month=" + month);
		}

		model.addAttribute("selectedYear", new BigDecimal(year));
		model.addAttribute("yearList", attendRegistService.getYearList());

		model.addAttribute("selectedMonth", new BigDecimal(month));
		model.addAttribute("monthList", attendRegistService.getMonthList());

		LocalDate targetDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
		List<AttendBusinessCalendar> calendarList = attendRegistService.getBusinessCalendarList(targetDate);
		model.addAttribute("calendarList", calendarList);

		// 定時情報を取得する
		String userId = sessionComponent.getValue(request.getSession(), "sessionUser",
				SessionLoginUser.class).get().getUserId();
		OntimeDto ontimeDto = attendRegistService.getOntimeDto(userId);
		model.addAttribute("ontimeDto", ontimeDto);

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
	public String complete() {
		return getView(DashboardView.ATTEND_REGIST_COMPLETE);
	}
}
