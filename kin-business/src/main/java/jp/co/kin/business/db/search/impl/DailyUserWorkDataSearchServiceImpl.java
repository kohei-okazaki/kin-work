package jp.co.kin.business.db.search.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.search.DailyUserWorkDataSearchService;
import jp.co.kin.db.dao.DailyUserWorkDataDao;

@Service
public class DailyUserWorkDataSearchServiceImpl implements DailyUserWorkDataSearchService {

	@Autowired
	private DailyUserWorkDataDao dao;

}
