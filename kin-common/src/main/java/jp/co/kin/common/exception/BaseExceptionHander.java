package jp.co.kin.common.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;

import jp.co.kin.common.context.MessageSourceComponent;
import jp.co.kin.common.log.type.LogLevel;

public abstract class BaseExceptionHander implements HandlerExceptionResolver {

	@Autowired
	private MessageSourceComponent messageCompenent;

	protected LogLevel getLogLevel(Exception e) {

		LogLevel loglevel = null;
		if (e instanceof BaseException) {
			BaseException be = (BaseException) e;
			switch (be.getErrorCode().getLogLevel()) {
			case FATAL:
				loglevel = LogLevel.FATAL;
				break;
			case ERROR:
				loglevel = LogLevel.ERROR;
				break;
			case WARN:
				loglevel = LogLevel.WARN;
				break;
			default:
				break;
			}
		} else if (e instanceof BaseRuntimeException) {
			BaseRuntimeException be = (BaseRuntimeException) e;
			switch (be.getErrorCode().getLogLevel()) {
			case FATAL:
				loglevel = LogLevel.FATAL;
				break;
			case ERROR:
				loglevel = LogLevel.ERROR;
				break;
			case WARN:
				loglevel = LogLevel.WARN;
				break;
			default:
				break;
			}
		} else {
			loglevel = LogLevel.ERROR;
		}

		return loglevel;
	}

	protected BaseErrorCode getErrorCode(Exception e) {

		BaseErrorCode errorCode;
		if (e instanceof BaseException) {
			BaseException be = (BaseException) e;
			errorCode = be.getErrorCode();
		} else if (e instanceof BaseRuntimeException) {
			BaseRuntimeException be = (BaseRuntimeException) e;
			errorCode = be.getErrorCode();
		} else {
			errorCode = CommonErrorCode.UNEXPECTED;
		}

		return errorCode;
	}

	protected String getDetail(Exception e) {

		String detail = "";
		if (e instanceof BaseException) {
			BaseException be = (BaseException) e;
			detail = be.getDetail();
		} else if (e instanceof BaseRuntimeException) {
			BaseRuntimeException be = (BaseRuntimeException) e;
			detail = be.getDetail();
		} else {
			detail = messageCompenent.getMessage(CommonErrorCode.UNEXPECTED.getOuterErrorCode());
		}
		return detail;
	}

}
