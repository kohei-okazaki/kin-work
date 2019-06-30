package jp.co.kin.dashboard.attendRegist.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.kin.business.attendRegist.AttendBusinessCalendor;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.dashboard.attendRegist.form.AttendRegistForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

@Controller
@RequestMapping("attendRegist")
public class AttendRegistController implements BaseViewController {

	@ModelAttribute("attendRegistForm")
	public AttendRegistForm setUpForm() {

		AttendRegistForm form = new AttendRegistForm();

		// FIXME DBから取得
		List<String> weekDayList = List.of("monday", "tuesDay", "wednesDay", "thursDay", "friDay", "stursDay",
				"sunDay");

		int weedDayPosition = 0;
		for (int i = 0; i < 15; i++) {
			String weekDay = weekDayList.get(weedDayPosition);
			weedDayPosition++;
			if (weedDayPosition == 7) {
				weedDayPosition = 0;
			}
			form.addDay(BigDecimal.valueOf(i + 1));
			form.addWeekDay(weekDay);
		}

		return form;
	}

	@GetMapping("/input")
	public String input(Model model) {

		// FIXME DBから取得
		List<String> weekDayList = List.of("monday", "tuesDay", "wednesDay", "thursDay", "friDay", "stursDay",
				"sunDay");

		List<AttendBusinessCalendor> calendorList = new ArrayList<>();
		int weedDayPosition = 0;
		for (int i = 0; i < 3; i++) {
			String weekDay = weekDayList.get(weedDayPosition);
			weedDayPosition++;
			if (weedDayPosition == 7) {
				weedDayPosition = 0;
			}
			AttendBusinessCalendor calendor = new AttendBusinessCalendor();
			calendor.setDay(BigDecimal.valueOf(i + 1));
			calendor.setWeekDay(weekDay);
		}

		model.addAttribute("calendorList", calendorList);
		calendorList.stream().forEach(e -> {
			LoggerFactory.getLogger(this.getClass()).debugRes(e);
		});

		return getView(DashboardView.ATTEND_REGIST_INPUT);
	}

	@PostMapping("/confirm")
	public String confirm(Model model, @Valid AttendRegistForm form, BindingResult result) {

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
