package jp.co.kin.dashboard.attendregist.controller;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

import jp.co.kin.business.attendregist.dto.AttendBusinessCalendar;
import jp.co.kin.business.attendregist.dto.AttendRegistDto;
import jp.co.kin.business.attendregist.service.AttendRegistService;
import jp.co.kin.business.db.search.DailyUserWorkDataSearchService;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.session.SessionLoginUser;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.common.context.SessionComponent;
import jp.co.kin.common.exception.CommonErrorCode;
import jp.co.kin.common.exception.SystemException;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.CollectionUtil;
import jp.co.kin.common.util.LocalDateTimeUtil;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.dashboard.attendregist.form.AttendRegistForm;
import jp.co.kin.dashboard.attendregist.form.AttendRegistUnitForm;
import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;
import jp.co.kin.web.interceptor.annotation.CsrfToken;

/**
 * 勤怠登録画面コントローラ
 *
 * @since 1.0.0
 */
@Controller
@RequestMapping("attendregist")
public class AttendRegistController implements BaseViewController {

    @Autowired
    private SessionComponent sessionComponent;
    @Autowired
    private AttendRegistService attendRegistService;
    @Autowired
    private DailyUserWorkDataSearchService dailyUserWorkDataSearchService;

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
    public String changeCalendar(Model model, HttpServletRequest request,
            @Valid AttendRegistForm form, BindingResult result) {

        if (result.hasErrors()) {
            initCalendar(model, request);
            return getView(DashboardView.ATTEND_REGIST_INPUT);
        }

        String year = form.getYear();
        String month = form.getMonth();
        LocalDate targetDate = LocalDate.of(Integer.parseInt(year),
                Integer.parseInt(month), 1);
        this.viewCalendar(model, request, new BigDecimal(year), new BigDecimal(month),
                targetDate);

        return getView(DashboardView.ATTEND_REGIST_INPUT);
    }

    @CsrfToken(factocy = true)
    @PostMapping("/confirm")
    public String confirm(Model model, @Valid AttendRegistForm form, BindingResult result,
            HttpServletRequest request) {

        if (result.hasErrors()) {
            // 初期表示を行うので入力画面へredirect
            return getRedirectView(DashboardView.ATTEND_REGIST_INPUT);
        }
        // 登録しない日付情報を削除する
        List<AttendRegistUnitForm> list = form.getRegistFormList().stream()
                .filter(e -> !StringUtil.isEmpty(e.getWorkStartHour()))
                .filter(e -> !StringUtil.isEmpty(e.getWorkStartMinute()))
                .filter(e -> !StringUtil.isEmpty(e.getWorkEndHour()))
                .filter(e -> !StringUtil.isEmpty(e.getWorkEndMinute()))
                .collect(Collectors.toList());
        if (CollectionUtil.isEmpty(list)) {
            // 初期表示を行うので入力画面へredirect
            return getRedirectView(DashboardView.ATTEND_REGIST_INPUT);
        }
        form.setRegistFormList(list);
        // 確認画面に表示する情報を設定する
        model.addAttribute("form", form);

        sessionComponent.setValue(request.getSession(), "requestForm", form);

        return getView(DashboardView.ATTEND_REGIST_CONFIRM);
    }

    @CsrfToken(check = true)
    @PostMapping("/complete")
    public String complete(Model model, HttpServletRequest request) {

        // sessionから勤怠登録情報を取得
        AttendRegistForm form = sessionComponent
                .getValue(request.getSession(), "requestForm", AttendRegistForm.class)
                .orElseThrow(() -> new SystemException(CommonErrorCode.SESSION_ILLEGAL,
                        "session情報が不正です"));

        // sessionからユーザ情報を取得
        SessionLoginUser sessionLoginUser = sessionComponent
                .getValue(request.getSession(), "sessionUser", SessionLoginUser.class)
                .get();

        // 定時情報を取得
        OntimeDto ontimeDto = attendRegistService
                .getOntimeDto(sessionLoginUser.getUserId());

        for (AttendRegistUnitForm regForm : form.getRegistFormList()) {
            // 勤怠登録formをdtoに変換する
            AttendRegistDto dto = DtoFactory.getDto(AttendRegistDto.class, form);
            dto.setUserId(sessionLoginUser.getUserId());
            dto.setCompanyCode(ontimeDto.getCompanyCode());
            dto.setWorkDataRegDate(
                    LocalDateTimeUtil.toLocalDate(LocalDateTimeUtil.getSysDate()));
            dto.setWorkStartDate(LocalDateTime.of(Integer.parseInt(form.getYear()),
                    Integer.parseInt(form.getMonth()), regForm.getDay().intValue(),
                    Integer.parseInt(regForm.getWorkStartHour()),
                    Integer.parseInt(regForm.getWorkStartMinute())));
            dto.setWorkEndDate(
                    LocalDateTime.of(Integer.parseInt(form.getYear()),
                            Integer.parseInt(form.getMonth()),
                            regForm.getDay().intValue(),
                            Integer.parseInt(regForm.getWorkEndHour()),
                            Integer.parseInt(regForm.getWorkEndMinute())));

            Duration diff = Duration.between(dto.getWorkStartDate(),
                    dto.getWorkEndDate());
            dto.setActualWorkTime(diff.toHoursPart() + "." + diff.toMinutesPart());

            attendRegistService.registDailyWorkData(dto);
        }

        sessionComponent.removeValue(request.getSession(), "requestForm");

        return getView(DashboardView.ATTEND_REGIST_COMPLETE);
    }

    /**
     * カレンダー情報をModelに設定する
     *
     * @param model
     *     Model
     * @param request
     *     HttpServletRequest
     * @param year
     *     年
     * @param month
     *     月
     * @param targetDate
     *     対象日時
     */
    private void viewCalendar(Model model, HttpServletRequest request, BigDecimal year,
            BigDecimal month, LocalDate targetDate) {

        model.addAttribute("selectedYear", year);
        model.addAttribute("yearList", attendRegistService.getYearList());
        model.addAttribute("selectedMonth", month);
        model.addAttribute("monthList", attendRegistService.getMonthList());

        // 定時情報を設定
        String userId = sessionComponent.getValue(request.getSession(), "sessionUser",
                SessionLoginUser.class).get().getUserId();
        model.addAttribute("ontimeDto", attendRegistService.getOntimeDto(userId));

        // カレンダーを取得
        List<AttendBusinessCalendar> calendarList = attendRegistService
                .getBusinessCalendarList(targetDate);
        // 日別ユーザ勤怠情報を対象日付で取得
        List<AttendRegistDto> dtoList = dailyUserWorkDataSearchService.searchList(userId,
                targetDate);

        for (AttendRegistDto attendRegistDto : dtoList) {
            for (AttendBusinessCalendar attendBusinessCalendar : calendarList) {
                if (new BigDecimal(
                        LocalDateTimeUtil.toString(attendRegistDto.getWorkStartDate(),
                                DateFormatType.DD))
                                        .equals(attendBusinessCalendar.getDay())) {

                    // 始業日時(時)
                    attendBusinessCalendar
                            .setWorkStartDateHour(
                                    LocalDateTimeUtil.toString(
                                            attendRegistDto.getWorkStartDate(),
                                            DateFormatType.HH));
                    // 始業日時(分)
                    attendBusinessCalendar
                            .setWorkStartDateMinute(
                                    LocalDateTimeUtil.toString(
                                            attendRegistDto.getWorkStartDate(),
                                            DateFormatType.MI));
                    // 終業日時(時)
                    attendBusinessCalendar
                            .setWorkEndDateHour(LocalDateTimeUtil.toString(
                                    attendRegistDto.getWorkEndDate(), DateFormatType.HH));
                    // 終業日時(分)
                    attendBusinessCalendar
                            .setWorkEndDateMinute(LocalDateTimeUtil.toString(
                                    attendRegistDto.getWorkEndDate(), DateFormatType.MI));
                } else {
                    continue;
                }
            }
        }
        model.addAttribute("calendarList", calendarList);
    }

    /**
     * システム日時からカレンダー情報を初期化する
     *
     * @param model
     *     Model
     * @param request
     *     HttpServletRequest
     */
    private void initCalendar(Model model, HttpServletRequest request) {
        BigDecimal year = new BigDecimal(
                LocalDateTimeUtil.toString(LocalDateTimeUtil.getSysDate(),
                        DateFormatType.YYYY));
        BigDecimal month = new BigDecimal(
                LocalDateTimeUtil.toString(LocalDateTimeUtil.getSysDate(),
                        DateFormatType.MM));
        LocalDate targetDate = LocalDateTimeUtil
                .toLocalDate(LocalDateTimeUtil.getSysDate());
        this.viewCalendar(model, request, year, month, targetDate);
    }
}
