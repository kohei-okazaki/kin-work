package jp.co.kin.business.db.create.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.create.LoginUserDataCreateService;
import jp.co.kin.db.dao.LoginUserDataDao;
import jp.co.kin.db.entity.LoginUserData;

/**
 * ログインユーザ情報作成サービス実装クラス
 * 
 * @since 1.0.0
 *
 */
@Service
public class LoginUserDataCreateServiceImpl implements LoginUserDataCreateService {

	@Autowired
	private LoginUserDataDao dao;

	@Override
	public void create(LoginUserData entity) {
		dao.insert(entity);
	}

}
