package jp.co.kin.dashboard.attendRegist.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.CalendarUtil;
import jp.co.kin.common.util.DateUtil;
import jp.co.kin.common.util.LocalDateTimeUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.dashboard.attendRegist.form.AttendRegistForm;
import jp.co.kin.dashboard.attendRegist.form.AttendRegistUnitForm;
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

		List<AttendBusinessCalendar> calendarList = new ArrayList<>();
		for (int i = 0; i < CalendarUtil.getLastDay(); i++) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, i + 1);

			String day = DateUtil.toString(cal.getTime(), DateFormatType.DD);
			String weekDay = CalendarUtil.getWeekDay(cal);

			AttendBusinessCalendar calendar = new AttendBusinessCalendar();
			calendar.setDay(new BigDecimal(day));
			calendar.setWeekDay(weekDay);
			calendarList.add(calendar);
		}
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
		}

		model.addAttribute("selectedYear", new BigDecimal(year));
		model.addAttribute("yearList", attendRegistService.getYearList());

		model.addAttribute("selectedMonth", new BigDecimal(month));
		model.addAttribute("monthList", attendRegistService.getMonthList());

		List<AttendBusinessCalendar> calendarList = new ArrayList<>();
		Calendar selectedCalendar = CalendarUtil.getSysCalendar();
		selectedCalendar.set(Calendar.YEAR, Integer.valueOf(year));
		selectedCalendar.set(Calendar.MONTH, Integer.valueOf(month) - 1);

		for (int i = 0; i < CalendarUtil.getLastDay(selectedCalendar); i++) {
			Calendar cal = selectedCalendar;
			cal.set(Calendar.DATE, i + 1);

			String day = DateUtil.toString(cal.getTime(), DateFormatType.DD);
			String weekDay = CalendarUtil.getWeekDay(cal);

			AttendBusinessCalendar calendar = new AttendBusinessCalendar();
			calendar.setDay(new BigDecimal(day));
			calendar.setWeekDay(weekDay);
			calendarList.add(calendar);
		}
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

		for (int i = 0; i < form.getRegistFormList().size(); i++) {
			AttendRegistUnitForm f = form.getRegistFormList().get(i);
			LoggerFactory.getLogger(this.getClass()).infoRes(f);
		}

		return getView(DashboardView.ATTEND_REGIST_CONFIRM);
	}

	@CsrfToken(check = true)
	@PostMapping("/complete")
	public String complete() {
		return getView(DashboardView.ATTEND_REGIST_COMPLETE);
	}
}
