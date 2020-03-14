package jp.co.kin.common.crypt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.test.BaseCommonTest;

/**
 * {@link AesCrypter} のjUnit
 *
 */
public class AesCrypterTest extends BaseCommonTest {

	private static final Logger LOG = LoggerFactory.getLogger(AesCrypterTest.class);

	@Autowired
	@Qualifier("aesCrypter")
	private Crypter crypter;

	@Test
	public void cryptTest() {
		try {
			String value = "あいうえお12345";
			String encryptValue = crypter.encrypt(value);
			String decryptValue = crypter.decrypt(encryptValue);
			assertEquals(value, decryptValue);
		} catch (Exception e) {
			LOG.error("#cryptTestに失敗", e);
		}

	}

}
