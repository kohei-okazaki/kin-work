package jp.co.kin.business.db.update;

import jp.co.kin.db.entity.OntimeMt;
import jp.co.kin.web.service.BaseService;

/**
 * 定時情報マスタ更新サービスインターフェース
 * 
 * @since 1.0.0
 *
 */
public interface OntimeMtUpdateService extends BaseService {

	/**
	 * 定時情報マスタを更新する
	 *
	 * @param entity
	 *            OntimeMt
	 */
	void update(OntimeMt entity);
}
