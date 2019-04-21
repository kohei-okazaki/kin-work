package jp.co.kin.common.crypt;

import jp.co.kin.common.exception.BaseException;
import jp.co.kin.common.type.Charset;

/**
 * Encode/Decode処理の基底インターフェース
 *
 */
public interface BaseEncodeAndDecoder {

	/**
	 * エンコードを行う
	 *
	 * @param src
	 *     エンコード対象文字列
	 * @param charset
	 *     文字コード
	 * @return
	 * @throws BaseException
	 *     指定した文字コードが不正だった場合
	 */
	String encode(String src, Charset charset) throws BaseException;

	/**
	 * デコードを行う
	 *
	 * @param src
	 *     デコード対象文字列
	 * @param charset
	 *     文字コード
	 * @return
	 * @throws BaseException
	 *     指定した文字コードが不正だった場合
	 */
	String decode(String src, Charset charset) throws BaseException;
}
