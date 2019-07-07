package jp.co.kin.business.ontimeRegist.service;

import jp.co.kin.business.ontimeRegist.dto.OntimeRegistDto;
import jp.co.kin.web.service.BaseService;

public interface OntimeRegistService extends BaseService {

	void regist(OntimeRegistDto dto);
}
