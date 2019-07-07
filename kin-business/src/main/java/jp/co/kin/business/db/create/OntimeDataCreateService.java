package jp.co.kin.business.db.create;

import jp.co.kin.db.entity.UserOntimeData;
import jp.co.kin.web.service.BaseService;

public interface OntimeDataCreateService extends BaseService {

	void create(UserOntimeData entity);

}
