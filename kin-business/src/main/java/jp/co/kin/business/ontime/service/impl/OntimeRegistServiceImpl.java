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

/**
 * 定時情報登録サービス実装クラス
 *
 * @since 1.0.0
 *
 */
@Service
public class OntimeRegistServiceImpl implements OntimeRegistService {

	/** 定時情報マスタ作成サービス */
	@Autowired
	private OntimeMtCreateService ontimeMtCreateService;
	/** 定時情報マスタ検索サービス */
	@Autowired
	private OntimeMtSearchService ontimeMtSearchService;
	/** 定時情報マスタ更新サービス */
	@Autowired
	private OntimeMtUpdateService ontimeMtUpdateService;

	@Override
	public void regist(OntimeDto dto) {

		OntimeMt entity = new OntimeMt();
		BeanUtil.copy(dto, entity);
		OntimeDto searchDto = selectByCompanyCode(dto.getCompanyCode());
		if (BeanUtil.isNull(searchDto)) {
			ontimeMtCreateService.create(entity);
		} else {
			ontimeMtUpdateService.update(entity);
		}

	}

	/**
	 * 指定した企業コードから定時情報Dtoを返す
	 *
	 * @param companyCode
	 *            企業コード
	 * @return 定時情報Dto
	 */
	private OntimeDto selectByCompanyCode(String companyCode) {
		return ontimeMtSearchService.searchByCompanyCode(companyCode);
	}

}
