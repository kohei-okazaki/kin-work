package jp.co.kin.business.ontime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.OntimeMtCreateService;
import jp.co.kin.business.db.search.OntimeMtSearchService;
import jp.co.kin.business.db.update.OntimeMtUpdateService;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.ontime.service.OntimeRegistService;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.db.entity.OntimeMt;

@Service
public class OntimeRegistServiceImpl implements OntimeRegistService {

	@Autowired
	private OntimeMtCreateService ontimeMtCreateService;
	@Autowired
	private OntimeMtSearchService ontimeMtSearchService;
	@Autowired
	private OntimeMtUpdateService ontimeMtUpdateService;

	@Override
	public void regist(OntimeDto dto) {

		OntimeMt entity = new OntimeMt();
		BeanUtil.copy(dto, entity);
		OntimeDto searchDto = selectByCompanyCode(dto);
		if (BeanUtil.isNull(searchDto)) {
			ontimeMtCreateService.create(entity);
		} else {
			ontimeMtUpdateService.update(entity);
		}

	}

	private OntimeDto selectByCompanyCode(OntimeDto dto) {
		return ontimeMtSearchService.searchByCompanyCode(dto.getCompanyCode());
	}

}
