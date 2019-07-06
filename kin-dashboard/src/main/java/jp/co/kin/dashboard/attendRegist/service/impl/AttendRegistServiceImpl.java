package jp.co.kin.dashboard.attendRegist.service.impl;

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
	public List<String> getYearList() {

		int sysdate = Integer.valueOf(DateUtil.toString(DateUtil.getSysDate(), DateFormatType.YYYY));
		return Stream.iterate(0, i -> ++i).limit(10).map(e -> String.valueOf(sysdate + e))
				.collect(Collectors.toList());
	}

	@Override
	public List<String> getMonthList() {
		return Stream.iterate(0, i -> ++i).limit(12).map(e -> String.valueOf(e + 1))
				.collect(Collectors.toList());
	}

}
