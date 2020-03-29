package jp.co.kin.business.ontime.service;

import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.web.service.BaseService;

/**
 * 定時情報登録サービスインターフェース
 *
 * @since 1.0.0
 */
public interface OntimeRegistService extends BaseService {

    /**
     * 定時情報を登録する
     *
     * @param dto
     *     定時情報Dto
     */
    void regist(OntimeDto dto);
}
