package jp.co.kin.business.db.search;

import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.web.service.BaseService;

public interface OntimeMtSearchService extends BaseService {

	OntimeDto searchByCompanyCode(String companyCode);
}
