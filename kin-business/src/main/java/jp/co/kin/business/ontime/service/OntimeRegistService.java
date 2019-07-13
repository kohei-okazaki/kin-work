package jp.co.kin.business.ontime.service;

import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.web.service.BaseService;

public interface OntimeRegistService extends BaseService {

	void regist(OntimeDto dto);
}
