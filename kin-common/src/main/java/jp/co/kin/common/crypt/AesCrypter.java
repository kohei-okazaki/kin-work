package jp.co.kin.common.crypt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.type.Algorithm;
import jp.co.kin.common.type.Charset;
import jp.co.kin.common.util.StringUtil;

/**
 * AESの可逆暗号クラス
 * 
 * @since 1.0.0
 */
@Component("aesCrypter")
public class AesCrypter implements Crypter {

	private static final Logger LOG = LoggerFactory.getLogger(AesCrypter.class);
	@Autowired
	private CryptComponent cryptComponent;

	@Override
	public String encrypt(String str) {

		if (StringUtil.isEmpty(str)) {
			return null;
		}

		try {
			byte[] key = getKey();
			SecretKeySpec sks = new SecretKeySpec(key, Algorithm.AES.getValue());
			byte[] input = str.getBytes(Charset.UTF_8.getValue());

			// 暗号化
			Cipher c = Cipher.getInstance(cryptComponent.getMode());
			c.init(Cipher.ENCRYPT_MODE, sks);

			byte[] encrypted = c.doFinal(input);
			return Base64.getEncoder().encodeToString(encrypted);

		} catch (Exception e) {
			LOG.error("暗号化処理が失敗しました", e);
			return null;
		}
	}

	@Override
	public String decrypt(String str) {

		if (StringUtil.isEmpty(str)) {
			return null;
		}

		try {
			byte[] key = getKey();
			SecretKeySpec sks = new SecretKeySpec(key, Algorithm.AES.getValue());
			byte[] input = Base64.getDecoder().decode(str);

			// 復号
			Cipher c = Cipher.getInstance(cryptComponent.getMode());
			c.init(Cipher.DECRYPT_MODE, sks);

			byte[] decrypted = c.doFinal(input);
			return new String(decrypted, Charset.UTF_8.getValue());

		} catch (Exception e) {
			LOG.error("復号処理が失敗しました", e);
			return null;
		}
	}

	/**
	 * 秘密鍵を返す
	 *
	 * @return 秘密鍵
	 * @throws UnsupportedEncodingException
	 *             文字コードの指定が不正の場合
	 */
	private byte[] getKey() throws UnsupportedEncodingException {
		return cryptComponent.getKey().getBytes(Charset.UTF_8.getValue());
	}
}
