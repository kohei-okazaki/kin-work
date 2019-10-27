package jp.co.kin.business.db.search.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.search.LoginUserDataSearchService;
import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.common.bean.BeanFactory;
import jp.co.kin.common.bean.DtoFactory;
import jp.co.kin.db.crypt.DecryptFunction;
import jp.co.kin.db.dao.LoginUserDataDao;
import jp.co.kin.db.entity.LoginUserData;

/**
 * ログインユーザ情報検索サービス実装クラス
 *
 * @since 1.0.0
 */
@Service
public class LoginUserDataSearchServiceImpl implements LoginUserDataSearchService {

	@Autowired
	private LoginUserDataDao dao;

	@Override
	@SuppressWarnings("unchecked")
	public LoginUserDataDto searchByLoginId(String loginId) {
		LoginUserData entity = dao.selectById(loginId, BeanFactory.getBean(DecryptFunction.class));
		return DtoFactory.getDto(LoginUserDataDto.class, entity);
	}

	@Override
	public int searchCountByLoginId(String loginId) {
		return dao.selectCountById(loginId);
	}

}
