package jp.co.kin.business.db.search;

import java.util.List;

import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.web.service.BaseService;

public interface OntimeMtSearchService extends BaseService {

	List<OntimeDto> search();

	OntimeDto searchByCompanyCode(String companyCode);
}
