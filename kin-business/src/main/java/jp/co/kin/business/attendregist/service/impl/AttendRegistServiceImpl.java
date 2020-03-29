package jp.co.kin.business.attendregist.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.attendregist.dto.AttendBusinessCalendar;
import jp.co.kin.business.attendregist.dto.AttendRegistDto;
import jp.co.kin.business.attendregist.service.AttendRegistService;
import jp.co.kin.business.db.create.DailyUserWorkDataCreateService;
import jp.co.kin.business.db.search.OntimeMtSearchService;
import jp.co.kin.business.db.search.UserBaseDataSearchService;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.userregist.dto.UserBaseDataDto;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.LocalDateTimeUtil;
import jp.co.kin.db.entity.DailyUserWorkData;

/**
 * 勤怠登録サービス実装クラス
 *
 * @since 1.0.0
 */
@Service
public class AttendRegistServiceImpl implements AttendRegistService {

    @Autowired
    private OntimeMtSearchService ontimeMtSearchService;
    @Autowired
    private UserBaseDataSearchService userBaseDataSearchService;
    @Autowired
    private DailyUserWorkDataCreateService dailyUserWorkDataCreateService;

    @Override
    public List<BigDecimal> getYearList() {
        LocalDate sysdate = LocalDateTimeUtil.toLocalDate(LocalDateTimeUtil.getSysDate());
        return Stream.iterate(0, i -> ++i).limit(10)
                .map(i -> {
                    LocalDate date = LocalDateTimeUtil.addYear(sysdate, i);
                    return new BigDecimal(
                            LocalDateTimeUtil.toString(date, DateFormatType.YYYY));
                }).collect(Collectors.toList());
    }

    @Override
    public List<BigDecimal> getMonthList() {
        return Stream.iterate(0, i -> ++i).limit(12).map(e -> new BigDecimal(e + 1))
                .collect(Collectors.toList());
    }

    @Override
    public OntimeDto getOntimeDto(String userId) {

        UserBaseDataDto userBaseDataDto = userBaseDataSearchService
                .searchByUserId(userId);
        OntimeDto ontimeDto = ontimeMtSearchService
                .searchByCompanyCode(userBaseDataDto.getCompanyCode());
        return ontimeDto;

    }

    @Override
    public List<AttendBusinessCalendar> getBusinessCalendarList(LocalDate targetDate) {
        return LocalDateTimeUtil.getLocalDateList(targetDate).stream().map(e -> {
            AttendBusinessCalendar calendar = new AttendBusinessCalendar();
            calendar.setDay(new BigDecimal(e.getDayOfMonth()));
            calendar.setWeekDay(e.getDayOfWeek().toString().toLowerCase());
            return calendar;
        }).collect(Collectors.toList());
    }

    @Override
    public void registDailyWorkData(AttendRegistDto dto) {
        DailyUserWorkData entity = new DailyUserWorkData();
        BeanUtil.copy(dto, entity);
        dailyUserWorkDataCreateService.create(entity);
    }

}
