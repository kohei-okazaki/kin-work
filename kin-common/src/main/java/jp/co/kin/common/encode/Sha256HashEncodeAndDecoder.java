package jp.co.kin.common.encode;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Component;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.type.Algorithm;
import jp.co.kin.common.type.Charset;
import jp.co.kin.common.util.StringUtil;

/**
 * SHA256エンコードクラス
 *
 * @since 1.0.0
 */
@Component("sha256HashEncodeAndDecoder")
public class Sha256HashEncodeAndDecoder implements BaseEncodeAndDecoder {

	private static final Logger LOG = LoggerFactory.getLogger(Sha256HashEncodeAndDecoder.class);

	@Override
	public String encode(String str, Charset charset) {

		if (StringUtil.isEmpty(str)) {
			return null;
		}

		try {

			MessageDigest messsageDigest = MessageDigest.getInstance(Algorithm.SHA_256.getValue());
			messsageDigest.update(str.getBytes(charset.getValue()));
			byte[] cipherByte = messsageDigest.digest();
			StringBuilder sb = new StringBuilder(2 * cipherByte.length);
			for (byte b : cipherByte) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			LOG.error("アルゴリズムが不正です Algorithm = " + Algorithm.SHA_256.getValue(), e);
		} catch (UnsupportedEncodingException e) {
			LOG.error("指定された文字コードが不正です charset=" + charset.getValue(), e);
		}

		return str;
	}

	@Override
	@Deprecated
	public String decode(String str, Charset charset) {
		return str;
	}

	/** パスワードを安全にするためのアルゴリズム */
	private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
	/** ストレッチング回数 */
	private static final int ITERATION_COUNT = 10000;
	/** 生成される鍵の長さ */
	private static final int KEY_LENGTH = 256;

	public String powerEncode(String str, Charset charset) {
		char[] passCharAry = str.toCharArray();
		String salt = "nok12345";
		byte[] hashedSalt = getHashedSalt(salt);

		PBEKeySpec keySpec = new PBEKeySpec(passCharAry, hashedSalt, ITERATION_COUNT,
				KEY_LENGTH);

		SecretKeyFactory skf;
		try {
			skf = SecretKeyFactory.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		SecretKey secretKey;
		try {
			secretKey = skf.generateSecret(keySpec);
		} catch (InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
		byte[] passByteAry = secretKey.getEncoded();

		// 生成されたバイト配列を16進数の文字列に変換
		StringBuilder sb = new StringBuilder(64);
		for (byte b : passByteAry) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	/**
	 * ソルトをハッシュ化して返却します ※ハッシュアルゴリズムはSHA-256を使用
	 *
	 * @param salt
	 *            ソルト
	 * @return ハッシュ化されたバイト配列のソルト
	 */
	private static byte[] getHashedSalt(String salt) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		messageDigest.update(salt.getBytes());
		return messageDigest.digest();
	}
}
