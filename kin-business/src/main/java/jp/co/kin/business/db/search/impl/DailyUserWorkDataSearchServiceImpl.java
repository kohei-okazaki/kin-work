package jp.co.kin.business.db.search.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.attendregist.dto.AttendRegistDto;
import jp.co.kin.business.db.search.DailyUserWorkDataSearchService;
import jp.co.kin.db.dao.DailyUserWorkDataDao;

@Service
public class DailyUserWorkDataSearchServiceImpl implements DailyUserWorkDataSearchService {

	@Autowired
	private DailyUserWorkDataDao dao;

	@Override
	public List<AttendRegistDto> searchList(String userId, LocalDate targetDate) {
		// List<LocalDate> dateList =
		// LocalDateTimeUtil.getLocalDateList(targetDate);
		// LocalDate workStartDate = dateList.get(0);
		// LocalDate workEndDate = dateList.get(dateList.size() - 1);
		// List<DailyUserWorkData> list = dao.selectByWorkDate(userId,
		// workStartDate, workEndDate);
		return null;
	}

}
