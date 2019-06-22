package jp.co.kin.common.exception;

public class SystemException extends BaseRuntimeException {

	private static final long serialVersionUID = 1L;

	public SystemException(RuntimeException e) {
		super(e);
	}

	public SystemException(BaseErrorCode errorCode, String detail) {
		super(errorCode, detail);
	}

	public SystemException(BaseErrorCode errorCode, String detail, RuntimeException e) {
		super(errorCode, detail, e);
	}

}
