package jp.co.kin.common.crypt;

/**
 * 暗号/復号インターフェース
 *
 * @since 1.0.0
 */
public interface Crypter {

	/**
	 * 暗号化を行う
	 *
	 * @param str
	 *            暗号化したい文字列
	 * @return 暗号化後の文字列
	 * @throws Exception
	 *             暗号化に失敗した場合
	 */
	String encrypt(String str) throws Exception;

	/**
	 * 復号を行う
	 *
	 * @param str
	 *            復号したい文字列
	 * @return 復号後の文字列
	 * @throws Exception
	 *             暗号化に失敗した場合
	 */
	String decrypt(String str) throws Exception;
}
