package jp.co.kin.common.exception;

public abstract class BaseRuntimeException extends RuntimeException {

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
	public BaseRuntimeException(RuntimeException e) {
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
	public BaseRuntimeException(BaseErrorCode errorCode, String detail) {
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
	public BaseRuntimeException(BaseErrorCode errorCode, String detail, RuntimeException e) {
		this(e);
		this.errorCode = errorCode;
		this.detail = detail;
	}

	/**
	 * errorCodeを返す
	 *
	 * @return errorCode
	 *
	 */
	public BaseErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * detailを返す
	 *
	 * @return detail
	 *
	 */
	public String getDetail() {
		return detail;
	}

}
