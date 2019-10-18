package jp.co.kin.business.db.create;

import jp.co.kin.db.entity.OntimeMt;
import jp.co.kin.web.service.BaseService;

/**
 * 定時情報マスタ作成サービスインターフェース
 * 
 * @since 1.0.0
 *
 */
public interface OntimeMtCreateService extends BaseService {

	void create(OntimeMt entity);

}
