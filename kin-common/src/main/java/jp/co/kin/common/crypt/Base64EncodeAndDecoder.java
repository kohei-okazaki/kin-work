package jp.co.kin.common.crypt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import jp.co.kin.common.exception.BaseException;
import jp.co.kin.common.exception.UnExpectedException;
import jp.co.kin.common.type.Charset;

public class Base64EncodeAndDecoder implements BaseEncodeAndDecoder {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encode(String src, Charset charset) throws BaseException {
		try {
			return Base64.getEncoder().encodeToString(src.getBytes(charset.getValue()));
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
			return new String(Base64.getDecoder().decode(src.getBytes(charset.getValue())), charset.getValue());
		} catch (UnsupportedEncodingException e) {
			throw new UnExpectedException(e);
		}
	}
}
