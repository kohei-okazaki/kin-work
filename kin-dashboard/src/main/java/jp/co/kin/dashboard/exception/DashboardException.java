package jp.co.kin.dashboard.exception;

import jp.co.kin.common.exception.BaseErrorCode;
import jp.co.kin.common.exception.BaseException;

public class DashboardException extends BaseException {

	private static final long serialVersionUID = 1L;

	public DashboardException(Exception e) {
		super(e);
	}

	public DashboardException(BaseErrorCode errorCode, String detail) {
		super(errorCode, detail);
	}

	public DashboardException(BaseErrorCode errorCode, String detail, RuntimeException e) {
		super(errorCode, detail, e);
	}

}
