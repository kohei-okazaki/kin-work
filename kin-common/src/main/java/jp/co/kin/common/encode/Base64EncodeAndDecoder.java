package jp.co.kin.common.encode;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.stereotype.Component;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.type.Charset;

/**
 * Base64エンコード/デコードクラス
 *
 * @since 1.0.0
 */
@Component("base64EncodeAndDecoder")
public class Base64EncodeAndDecoder implements BaseEncodeAndDecoder {

    private static final Logger LOG = LoggerFactory
            .getLogger(Base64EncodeAndDecoder.class);

    @Override
    public String encode(String str, Charset charset) {
        try {
            return Base64.getEncoder().encodeToString(str.getBytes(charset.getValue()));
        } catch (UnsupportedEncodingException e) {
            LOG.error("指定された文字コードが不正です charset=" + charset.getValue(), e);
            return null;
        }
    }

    @Override
    public String decode(String str, Charset charset) {
        try {
            return new String(
                    Base64.getDecoder().decode(str.getBytes(charset.getValue())),
                    charset.getValue());
        } catch (UnsupportedEncodingException e) {
            LOG.error("指定された文字コードが不正です charset=" + charset.getValue(), e);
            return null;
        }
    }
}
