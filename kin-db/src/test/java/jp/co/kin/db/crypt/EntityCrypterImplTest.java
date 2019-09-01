package jp.co.kin.db.crypt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.db.test.BaseDbTest;

/**
 * {@link EntityCrypterImpl} のjUnit
 *
 */
public class EntityCrypterImplTest extends BaseDbTest {

	@Autowired
	private EntityCrypter entityCrypter;

	@Test
	public void cryptTest() {
		TestCryptEntity entity = new TestCryptEntity();
		entity.setName("平文");
		entity.setCryptName("平文");

		entityCrypter.encrypt(entity);
		entityCrypter.decrypt(entity);

		assertEquals("平文", entity.getName());
		assertEquals("平文", entity.getCryptName());
	}

}
