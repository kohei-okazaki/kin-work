package jp.co.kin.common.exception;

/**
 * 基底例外クラス
 *
 */
public abstract class BaseException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private String detail;

	public BaseException() {
		super();
	}

	public BaseException(Exception e) {
		super(e);
	}

	public BaseException(String detail, Exception e) {
		super(e);
		this.detail = detail;
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
