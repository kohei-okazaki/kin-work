package jp.co.kin.common.encode;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jp.co.kin.common.test.BaseCommonTest;
import jp.co.kin.common.type.Charset;

/**
 * {@link Sha256HashEncodeAndDecoder} のjUnit
 */
public class Sha256HashEncodeAndDecoderTest extends BaseCommonTest {

    @Autowired
    @Qualifier("sha256HashEncodeAndDecoder")
    private Sha256HashEncodeAndDecoder encodeAndDecoder;

    @Test
    public void testEncode() {
        {
            String s = "testPassword";
            String str = encodeAndDecoder.encode(s, Charset.UTF_8);
            System.out.println(str);
        }
        {
            String s = "testPassword";
            String str = encodeAndDecoder.powerEncode(s, Charset.UTF_8);
            System.out.println(str);
        }
    }

}
