package jp.co.kin.business.db.search;

import jp.co.kin.business.ontimeRegist.dto.OntimeRegistDto;
import jp.co.kin.web.service.BaseService;

public interface OntimeDataSearchService extends BaseService {

	OntimeRegistDto searchByLoginId(OntimeRegistDto dto);

	int searchCountByLoginId(String loginId);
}
