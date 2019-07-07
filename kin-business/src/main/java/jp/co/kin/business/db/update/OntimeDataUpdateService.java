package jp.co.kin.business.db.update;

import jp.co.kin.db.entity.UserOntimeData;
import jp.co.kin.web.service.BaseService;

public interface OntimeDataUpdateService extends BaseService {

	void update(UserOntimeData entity);
}
