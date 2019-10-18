package jp.co.kin.common.encode;

import jp.co.kin.common.type.Charset;

/**
 * Encode/Decodeの基底インターフェース
 * 
 * @since 1.0.0
 */
public interface BaseEncodeAndDecoder {

	/**
	 * エンコードを行う
	 *
	 * @param str
	 *            エンコード対象文字列
	 * @param charset
	 *            文字コード
	 * @return エンコード後の文字列
	 *
	 */
	String encode(String str, Charset charset);

	/**
	 * デコードを行う
	 *
	 * @param str
	 *            デコード対象文字列
	 * @param charset
	 *            文字コード
	 * @return デコード後の文字列
	 *
	 */
	String decode(String str, Charset charset);

}
