package jp.co.kin.business.db.create.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.DailyUserWorkDataCreateService;
import jp.co.kin.db.dao.DailyUserWorkDataDao;
import jp.co.kin.db.entity.DailyUserWorkData;

/**
 * 日別ユーザ勤怠情報作成サービス実装クラス
 *
 * @since 1.0.0
 *
 */
@Service
public class DailyUserWorkDataCreateServiceImpl implements DailyUserWorkDataCreateService {

	@Autowired
	private DailyUserWorkDataDao dao;

	@Override
	public void create(DailyUserWorkData entity) {
		dao.insert(entity);
	}

}
