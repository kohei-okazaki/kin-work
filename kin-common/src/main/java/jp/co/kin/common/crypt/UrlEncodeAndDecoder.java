package jp.co.kin.common.crypt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import jp.co.kin.common.exception.BaseException;
import jp.co.kin.common.exception.UnExpectedException;
import jp.co.kin.common.type.Charset;

public class UrlEncodeAndDecoder implements BaseEncodeAndDecoder {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encode(String src, Charset charset) throws BaseException {
		try {
			return URLEncoder.encode(src, charset.getValue());
		} catch (UnsupportedEncodingException e) {
			throw new UnExpectedException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String decode(String src, Charset charset) throws BaseException {
		try {
			return URLDecoder.decode(src, charset.getValue());
		} catch (UnsupportedEncodingException e) {
			throw new UnExpectedException(e);
		}
	}

}
