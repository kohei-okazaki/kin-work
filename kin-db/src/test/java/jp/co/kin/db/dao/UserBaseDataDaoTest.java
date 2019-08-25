package jp.co.kin.db.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.db.entity.UserBaseData;
import jp.co.kin.db.test.BaseDbTest;

/**
 * {@link UserBaseDataDao} のjUnit
 *
 */
public class UserBaseDataDaoTest extends BaseDbTest {

	@Autowired
	private UserBaseDataDao dao;

	@Test
	public void selectByIdTest() {
		{
			// entityが存在する場合
			String id = "admin";
			UserBaseData entity = dao.selectById(id);
			assertEquals(id, entity.getUserId());
		}
		{
			// entityが存在しない場合
			String id = "dummyId";
			UserBaseData entity = dao.selectById(id);
			assertEquals(null, entity);
		}
	}

}
