package jp.co.kin.business.exception;

import jp.co.kin.common.exception.BaseErrorCode;
import jp.co.kin.common.log.type.LogLevel;

public enum BusinessErrorCode implements BaseErrorCode {

	;

	private BusinessErrorCode(String outerErrorCode, LogLevel logLevel) {
		this.outerErrorCode = outerErrorCode;
		this.logLevel = logLevel;
	}

	/** 外部用エラーコード */
	private String outerErrorCode;
	/** ログレベル */
	private LogLevel logLevel;

	@Override
	public String getOuterErrorCode() {
		return this.outerErrorCode;
	}

	@Override
	public LogLevel getLogLevel() {
		return this.logLevel;
	}

}
