package jp.co.kin.business.db.create;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.test.BaseBusinessTest;
import jp.co.kin.db.entity.UserBaseData;

/**
 * {@link UserBaseDataCreateService} のjUnit
 *
 */
public class UserBaseDataCreateServiceTest extends BaseBusinessTest {

	@Autowired
	private UserBaseDataCreateService service;

	@Test
	public void createTest() {
		UserBaseData entity = new UserBaseData();
		entity.setUserId("tttttt");
		entity.setCompanyCode("12345");
		service.create(entity);
	}
}
