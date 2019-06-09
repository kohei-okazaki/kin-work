package jp.co.kin.common.exception;

public abstract class BaseException extends Exception {

	/** シリアルバージョンUID */
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 *
	 * @param e
	 *            例外クラス
	 */
	public BaseException(Exception e) {
		super(e);
	}
}
