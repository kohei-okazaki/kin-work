package jp.co.kin.business.ontimeRegist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.OntimeDataCreateService;
import jp.co.kin.business.db.search.OntimeDataSearchService;
import jp.co.kin.business.db.update.OntimeDataUpdateService;
import jp.co.kin.business.ontimeRegist.dto.OntimeRegistDto;
import jp.co.kin.business.ontimeRegist.service.OntimeRegistService;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.db.entity.UserOntimeData;

@Service
public class OntimeRegistServiceImpl implements OntimeRegistService {

	@Autowired
	private OntimeDataCreateService ontimeDataCreateService;
	@Autowired
	private OntimeDataSearchService ontimeDataSearchService;
	@Autowired
	private OntimeDataUpdateService ontimeDataUpdateService;

	@Override
	public void regist(OntimeRegistDto dto) {

		UserOntimeData entity = new UserOntimeData();
		BeanUtil.copy(dto, entity);
		OntimeRegistDto searchDto = selectById(dto);
		if (BeanUtil.isNull(searchDto)) {
			ontimeDataCreateService.create(entity);
		} else {
			ontimeDataUpdateService.update(entity);
		}

	}

	private OntimeRegistDto selectById(OntimeRegistDto dto) {
		return ontimeDataSearchService.searchByLoginId(dto.getLoginId());
	}

}
