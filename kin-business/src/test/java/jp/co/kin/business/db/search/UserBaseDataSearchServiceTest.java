package jp.co.kin.business.db.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.test.BaseBusinessTest;
import jp.co.kin.business.userregist.dto.UserBaseDataDto;

/**
 * {@link UserBaseDataSearchService} のjUnit
 *
 */
public class UserBaseDataSearchServiceTest extends BaseBusinessTest {

	@Autowired
	private UserBaseDataSearchService service;

	@Test
	public void searchByUserIdTest() {
		{
			String userId = "dummyId";
			UserBaseDataDto dto = service.searchByUserId(userId);
			assertEquals(null, dto);
		}
		{
			String userId = "KCtest";
			UserBaseDataDto dto = service.searchByUserId(userId);
			assertEquals(userId, dto.getUserId());
		}
	}

}
