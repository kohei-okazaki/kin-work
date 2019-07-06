package jp.co.kin.dashboard.attendRegist.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import jp.co.kin.business.session.annotation.CsrfToken;
import jp.co.kin.common.exception.BaseException;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.DateUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.dashboard.attendRegist.form.AttendRegistForm;
import jp.co.kin.dashboard.attendRegist.form.AttendRegistUnitForm;
import jp.co.kin.dashboard.attendRegist.service.AttendRegistService;
import jp.co.kin.dashboard.exception.DashboardErrorCode;
import jp.co.kin.dashboard.exception.DashboardException;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

@Controller
@RequestMapping("attendRegist")
public class AttendRegistController implements BaseViewController {

	@Autowired
	private AttendRegistService attendRegistService;

	@ModelAttribute("attendRegistForm")
	public AttendRegistForm setUpForm() {
		return new AttendRegistForm();
	}

	@GetMapping("/input")
	public String input(Model model) {

		// FIXME DBから取得
		List<String> weekDayList = List.of("monday", "tuesDay", "wednesDay", "thursDay", "friDay", "stursDay",
				"sunDay");

		List<AttendBusinessCalendar> calendarList = new ArrayList<>();
		int weekDayPosition = 0;
		for (int i = 0; i < 31; i++) {
			String weekDay = weekDayList.get(weekDayPosition);
			weekDayPosition++;
			if (weekDayPosition == 7) {
				weekDayPosition = 0;
			}
			AttendBusinessCalendar calendar = new AttendBusinessCalendar();
			calendar.setDay(BigDecimal.valueOf(i + 1));
			calendar.setWeekDay(weekDay);
			calendarList.add(calendar);
		}

		model.addAttribute("calendarList", calendarList);

		model.addAttribute("selectedYear", DateUtil.toString(DateUtil.getSysDate(), DateFormatType.YYYY));
		model.addAttribute("yearList", attendRegistService.getYearList());

		model.addAttribute("selectedMonth",
				DateUtil.toString(DateUtil.getSysDate(), DateFormatType.MM).replaceFirst("0", ""));
		model.addAttribute("monthList", attendRegistService.getMonthList());

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

		model.addAttribute("selectedYear", year);
		model.addAttribute("yearList", attendRegistService.getYearList());

		model.addAttribute("selectedMonth", month);
		model.addAttribute("monthList", attendRegistService.getMonthList());

		return getView(DashboardView.ATTEND_REGIST_INPUT);
	}

	@CsrfToken(factocy = true)
	@PostMapping("/confirm")
	public String confirm(Model model, @Valid AttendRegistForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getView(DashboardView.ATTEND_REGIST_INPUT);
		}

		for (int i = 0; i < form.getRegistFormList().size(); i++) {
			AttendRegistUnitForm f = form.getRegistFormList().get(i);
			LoggerFactory.getLogger(this.getClass()).info(f.getDay().toPlainString());
			LoggerFactory.getLogger(this.getClass()).info(f.getWeekDay());
			LoggerFactory.getLogger(this.getClass()).info(f.getWorkStartTime());
			LoggerFactory.getLogger(this.getClass()).info(f.getWorkEndTime());
		}

		return getView(DashboardView.ATTEND_REGIST_CONFIRM);
	}

	@CsrfToken(check = true)
	@PostMapping("/complete")
	public String complete() {
		return getView(DashboardView.ATTEND_REGIST_COMPLETE);
	}
}
