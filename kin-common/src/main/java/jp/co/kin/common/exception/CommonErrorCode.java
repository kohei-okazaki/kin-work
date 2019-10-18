package jp.co.kin.common.exception;

import jp.co.kin.common.log.type.LogLevel;

/**
 * 共通エラーコードの列挙
 * 
 * @since 1.0.0
 *
 */
public enum CommonErrorCode implements BaseErrorCode {

	/** 予期せぬ例外 */
	UNEXPECTED("EC0001", LogLevel.ERROR),

	/** session例外 */
	SESSION_ILLEGAL("WC0002", LogLevel.WARN);

	/** 外部用エラーコード */
	private String outerErrorCode;
	/** ログレベル */
	private LogLevel logLevel;

	private CommonErrorCode(String outerErrorCode, LogLevel logLevel) {
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
