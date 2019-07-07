package jp.co.kin.business.db.search;

import jp.co.kin.business.ontimeRegist.dto.OntimeRegistDto;
import jp.co.kin.web.service.BaseService;

public interface OntimeDataSearchService extends BaseService {

	OntimeRegistDto searchByLoginId(String loginId);

	int searchCountByLoginId(String loginId);
}
