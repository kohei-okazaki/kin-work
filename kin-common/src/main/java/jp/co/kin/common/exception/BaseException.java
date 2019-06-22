package jp.co.kin.common.exception;

public abstract class BaseException extends Exception {

	/** シリアルバージョンUID */
	private static final long serialVersionUID = 1L;

	/** エラーコード */
	private BaseErrorCode errorCode;
	/** 詳細 */
	private String detail;

	/**
	 * コンストラクタ
	 *
	 * @param e
	 *            例外クラス
	 */
	public BaseException(Exception e) {
		super(e);
	}

	/**
	 * コンストラクタ
	 *
	 * @param errorCode
	 *            エラーコード
	 * @param detail
	 *            詳細
	 */
	public BaseException(BaseErrorCode errorCode, String detail) {
		this.errorCode = errorCode;
		this.detail = detail;
	}

	/**
	 * コンストラクタ
	 *
	 * @param errorCode
	 *            エラーコード
	 * @param detail
	 *            詳細
	 * @param e
	 *            例外クラス
	 */
	public BaseException(BaseErrorCode errorCode, String detail, Exception e) {
		this(e);
		this.errorCode = errorCode;
		this.detail = detail;
	}

	/**
	 * errorCodeを返す
	 *
	 * @return errorCode
	 */
	public BaseErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * detailを返す
	 *
	 * @return detail
	 */
	public String getDetail() {
		return detail;
	}

}
