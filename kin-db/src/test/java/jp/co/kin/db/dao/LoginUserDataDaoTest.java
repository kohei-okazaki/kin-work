package jp.co.kin.db.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.db.crypt.DecryptFunction;
import jp.co.kin.db.entity.LoginUserData;
import jp.co.kin.db.test.BaseDbTest;

/**
 * {@link LoginUserDataDao} のjUnit
 *
 */
public class LoginUserDataDaoTest extends BaseDbTest {

	@Autowired
	private LoginUserDataDao dao;
	@Autowired
	private DecryptFunction<LoginUserData> decryptFuinction;

	@Test
	public void selectByIdTest() {
		{
			// entityが存在する場合
			String id = "test";
			LoginUserData entity = dao.selectById(id, decryptFuinction);
			assertEquals(id, entity.getLoginId());
		}
		{
			// entityが存在しない場合
			String id = "dummyId";
			LoginUserData entity = dao.selectById(id, decryptFuinction);
			assertEquals(null, entity);
		}
	}

	@Test
	public void selectCountById() {
		{
			String loginId = "test";
			assertEquals(1, dao.selectCountById(loginId));
		}
	}
}
