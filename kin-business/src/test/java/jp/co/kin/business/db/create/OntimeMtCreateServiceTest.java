package jp.co.kin.business.db.create;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.test.BaseBusinessTest;
import jp.co.kin.db.entity.OntimeMt;

/**
 * {@link OntimeMtCreateService} のjUnit
 *
 */
public class OntimeMtCreateServiceTest extends BaseBusinessTest {

	@Autowired
	private OntimeMtCreateService service;

	@Test
	public void createTest() {
		OntimeMt entity = new OntimeMt();
		entity.setCompanyCode("12346");
		entity.setWorkStartHour("01");
		entity.setWorkStartMinute("01");
		entity.setWorkEndHour("01");
		entity.setWorkEndMinute("01");
		service.create(entity);
	}
}
