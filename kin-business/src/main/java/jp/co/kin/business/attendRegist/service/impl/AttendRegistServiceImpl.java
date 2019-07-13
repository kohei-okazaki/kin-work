package jp.co.kin.business.attendRegist.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.attendRegist.service.AttendRegistService;
import jp.co.kin.business.db.search.OntimeMtSearchService;
import jp.co.kin.business.db.search.UserBaseDataSearchService;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.userRegist.UserBaseDataDto;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.DateUtil;

@Service
public class AttendRegistServiceImpl implements AttendRegistService {

	@Autowired
	private OntimeMtSearchService ontimeMtSearchService;
	@Autowired
	private UserBaseDataSearchService userBaseDataSearchService;

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

	@Override
	public OntimeDto getOntimeDto(String userId) {

		UserBaseDataDto userBaseDataDto = userBaseDataSearchService.searchByUserId(userId);
		OntimeDto ontimeDto = ontimeMtSearchService.searchByCompanyCode(userBaseDataDto.getCompanyCode());
		return ontimeDto;

	}

}
