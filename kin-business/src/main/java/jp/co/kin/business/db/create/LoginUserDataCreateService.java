package jp.co.kin.business.db.create;

import jp.co.kin.db.entity.LoginUserData;
import jp.co.kin.web.service.BaseService;

public interface LoginUserDataCreateService extends BaseService {

	void create(LoginUserData entity);
}
