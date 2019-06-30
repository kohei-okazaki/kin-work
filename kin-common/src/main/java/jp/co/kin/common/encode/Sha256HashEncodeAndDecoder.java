package jp.co.kin.common.encode;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.type.Algorithm;
import jp.co.kin.common.type.Charset;
import jp.co.kin.common.util.StringUtil;

/**
 * SHA256エンコードクラス
 *
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
	public String decode(String str, Charset charset) {
		return str;
	}
}
