package jp.co.kin.business.db.create;

import jp.co.kin.db.entity.DailyUserWorkData;
import jp.co.kin.web.service.BaseService;

public interface DailyUserWorkDataCreateService extends BaseService {

	void create(DailyUserWorkData entity);
}
