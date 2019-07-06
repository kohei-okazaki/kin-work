package jp.co.kin.dashboard.attendRegist.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.DateUtil;
import jp.co.kin.dashboard.attendRegist.service.AttendRegistService;

@Service
public class AttendRegistServiceImpl implements AttendRegistService {

	@Override
	public List<BigDecimal> getYearList() {

		int sysdate = Integer.valueOf(DateUtil.toString(DateUtil.getSysDate(), DateFormatType.YYYY));
		return Stream.iterate(0, i -> ++i).limit(10).map(e -> new BigDecimal(sysdate + e))
				.collect(Collectors.toList());
	}

	@Override
	public List<BigDecimal> getMonthList() {
		return Stream.iterate(0, i -> ++i).limit(12).map(e -> new BigDecimal(e + 1))
				.collect(Collectors.toList());
	}

}
