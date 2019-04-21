package jp.co.kin.common.exception;

public class UnExpectedException extends BaseException {

	public UnExpectedException() {
		super();
	}

	public UnExpectedException(Exception e) {
		super(e);
	}

	public UnExpectedException(String detail, Exception e) {
		super(detail, e);
	}
}
