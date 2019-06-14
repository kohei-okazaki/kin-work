package jp.co.kin.common.db;

public interface Crypter {

	/**
	 * 暗号化を行う
	 *
	 * @param str
	 *            暗号化したい文字列
	 * @return
	 */
	String encrypt(String str);

	/**
	 * 復号処理を行う
	 *
	 * @param str
	 *            復号したい文字列
	 * @return
	 */
	String decrypt(String str);
}