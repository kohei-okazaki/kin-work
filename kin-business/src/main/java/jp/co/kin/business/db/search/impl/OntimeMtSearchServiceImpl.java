package jp.co.kin.business.db.search.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.search.OntimeMtSearchService;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.db.dao.OntimeMtDao;
import jp.co.kin.db.entity.OntimeMt;

@Service
public class OntimeMtSearchServiceImpl implements OntimeMtSearchService {

	@Autowired
	private OntimeMtDao dao;

	@Override
	public List<OntimeDto> search() {
		List<OntimeMt> mtList = dao.select();
		return mtList.stream().map(e -> DtoFactory.getDto(OntimeDto.class, e))
				.collect(Collectors.toList());
	}

	@Override
	public OntimeDto searchByCompanyCode(String companyCode) {
		OntimeMt mt = dao.selectById(companyCode);
		return DtoFactory.getDto(OntimeDto.class, mt);
	}

}
