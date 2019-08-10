package jp.co.kin.business.attendregist.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.attendregist.dto.AttendBusinessCalendar;
import jp.co.kin.business.attendregist.service.AttendRegistService;
import jp.co.kin.business.db.search.OntimeMtSearchService;
import jp.co.kin.business.db.search.UserBaseDataSearchService;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.userregist.dto.UserBaseDataDto;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.LocalDateTimeUtil;

@Service
public class AttendRegistServiceImpl implements AttendRegistService {

	@Autowired
	private OntimeMtSearchService ontimeMtSearchService;
	@Autowired
	private UserBaseDataSearchService userBaseDataSearchService;

	@Override
	public List<BigDecimal> getYearList() {
		LocalDate sysdate = LocalDateTimeUtil.toLocalDate(LocalDateTimeUtil.getSysDate());
		List<LocalDate> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(LocalDateTimeUtil.addYear(sysdate, i));
		}
		return list.stream().map(e -> LocalDateTimeUtil.toString(e, DateFormatType.YYYY))
				.map(e -> new BigDecimal(e)).collect(Collectors.toList());
	}

	@Override
	public List<BigDecimal> getMonthList() {
		return Stream.iterate(0, i -> ++i).limit(12).map(e -> new BigDecimal(e + 1))
				.collect(Collectors.toList());
	}

	@Override
	public OntimeDto getOntimeDto(String userId) {

		UserBaseDataDto userBaseDataDto = userBaseDataSearchService.searchByUserId(userId);
		OntimeDto ontimeDto = ontimeMtSearchService.searchByCompanyCode(userBaseDataDto.getCompanyCode());
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

}
