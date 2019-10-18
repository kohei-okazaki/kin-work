package jp.co.kin.business.db.create;

import jp.co.kin.db.entity.DailyUserWorkData;
import jp.co.kin.web.service.BaseService;

/**
 * 日別ユーザ勤怠情報作成サービスインターフェース
 *
 * @since 1.0.0
 *
 */
public interface DailyUserWorkDataCreateService extends BaseService {

	void create(DailyUserWorkData entity);
}
