package jp.co.kin.business.exception;

import jp.co.kin.common.exception.BaseErrorCode;
import jp.co.kin.common.log.type.LogLevel;

/**
 * 業務エラーコードの列挙
 *
 * @since 1.0.0
 */
public enum BusinessErrorCode implements BaseErrorCode {

	;

	/** 外部用エラーコード */
	private String outerErrorCode;
	/** ログレベル */
	private LogLevel logLevel;

	private BusinessErrorCode(String outerErrorCode, LogLevel logLevel) {
		this.outerErrorCode = outerErrorCode;
		this.logLevel = logLevel;
	}

	@Override
	public String getOuterErrorCode() {
		return this.outerErrorCode;
	}

	@Override
	public LogLevel getLogLevel() {
		return this.logLevel;
	}

}
