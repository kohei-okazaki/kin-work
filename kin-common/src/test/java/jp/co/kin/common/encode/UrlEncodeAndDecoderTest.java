package jp.co.kin.common.encode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jp.co.kin.common.test.BaseCommonTest;
import jp.co.kin.common.type.Charset;

/**
 * {@link UrlEncodeAndDecoder} のjUnit
 *
 */
public class UrlEncodeAndDecoderTest extends BaseCommonTest {

	@Autowired
	@Qualifier("urlEncodeAndDecoder")
	private BaseEncodeAndDecoder encodeAndDecoder;

	@Test
	public void encodeAndDecodeUTF_8NormalTest() {
		String value = "あいうえお12345";
		String encValue = encodeAndDecoder.encode(value, Charset.UTF_8);
		String decValue = encodeAndDecoder.decode(encValue, Charset.UTF_8);
		assertEquals(value, decValue);
	}

	@Test
	public void encodeAndDecodeMS_932NormalTest() {
		String value = "あいうえお12345";
		String encValue = encodeAndDecoder.encode(value, Charset.MS_932);
		String decValue = encodeAndDecoder.decode(encValue, Charset.MS_932);
		assertEquals(value, decValue);
	}

	@Test
	public void encodeCharsetErrorTest() {
		String value = "あいうえお12345";
		String encValue = encodeAndDecoder.encode(value, Charset.MS_932);
		String decValue = encodeAndDecoder.decode(encValue, Charset.UTF_8);
		assertNotEquals(value, decValue);
	}

	@Test
	public void decodeCharsetErrorTest() {
		String value = "あいうえお12345";
		String encValue = encodeAndDecoder.encode(value, Charset.UTF_8);
		String decValue = encodeAndDecoder.decode(encValue, Charset.MS_932);
		assertNotEquals(value, decValue);
	}
}
