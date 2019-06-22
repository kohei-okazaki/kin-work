package jp.co.kin.common.exception;

import jp.co.kin.common.log.type.LogLevel;

public enum CommonErrorCode implements BaseErrorCode {

	/** 予期せぬ例外 */
	UNEXPECTED("EC001", LogLevel.ERROR);

	/**
	 * コンストラクタ
	 *
	 * @param outerErrorCode
	 *            外部用エラーコード
	 * @param logLevel
	 *            ログレベル
	 */
	private CommonErrorCode(String outerErrorCode, LogLevel logLevel) {
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
