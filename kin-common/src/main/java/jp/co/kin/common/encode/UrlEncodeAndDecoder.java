package jp.co.kin.common.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.type.Charset;

/**
 * URLエンコード/デコードクラス
 * 
 * @since 1.0.0
 */
@Component("urlEncodeAndDecoder")
public class UrlEncodeAndDecoder implements BaseEncodeAndDecoder {

	private static final Logger LOG = LoggerFactory.getLogger(UrlEncodeAndDecoder.class);

	@Override
	public String encode(String str, Charset charset) {
		try {
			return URLEncoder.encode(str, charset.getValue());
		} catch (UnsupportedEncodingException e) {
			LOG.error("指定された文字コードが不正です charset=" + charset.getValue(), e);
			return null;
		}
	}

	@Override
	public String decode(String str, Charset charset) {
		try {
			return URLDecoder.decode(str, charset.getValue());
		} catch (UnsupportedEncodingException e) {
			LOG.error("指定された文字コードが不正です charset=" + charset.getValue(), e);
			return null;
		}
	}

}
