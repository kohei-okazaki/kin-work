package jp.co.kin.business.userregist.service;

import jp.co.kin.business.userregist.dto.UserRegistDto;
import jp.co.kin.web.service.BaseService;

/**
 * ログインユーザ登録サービスインターフェース
 *
 * @since 1.0.0
 *
 */
public interface LoginUserRegistService extends BaseService {

	/**
	 * ユーザ登録を行う
	 * 
	 * @param dto
	 *            ユーザ登録DTO
	 */
	void regist(UserRegistDto dto);

	/**
	 * ユーザ登録DTOが重複しているかどうか判定する<br>
	 * 重複している場合true、それ以外の場合false
	 *
	 * @param dto
	 *            ユーザ登録DTO
	 * @return 評価値
	 */
	boolean isDuplicateLoginId(UserRegistDto dto);
}
