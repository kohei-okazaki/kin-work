package jp.co.kin.business.db.search.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.search.OntimeDataSearchService;
import jp.co.kin.business.ontimeRegist.dto.OntimeRegistDto;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.db.dao.UserOntimeDataDao;
import jp.co.kin.db.entity.UserOntimeData;

@Service
public class OntimeDataSearchServiceImpl implements OntimeDataSearchService {

	@Autowired
	private UserOntimeDataDao dao;

	@Override
	public OntimeRegistDto searchByLoginId(OntimeRegistDto dto) {

		UserOntimeData entity = dao.selectById(dto.getLoginId());
		return DtoFactory.getDto(OntimeRegistDto.class, entity);
	}

	@Override
	public int searchCountByLoginId(String loginId) {
		return dao.selectCountById(loginId);
	}

}
