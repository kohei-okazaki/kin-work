package jp.co.kin.dashboard.exception;

import jp.co.kin.common.exception.BaseErrorCode;
import jp.co.kin.common.log.type.LogLevel;

public enum DashboardErrorCode implements BaseErrorCode {

	/** 不正なリクエストエラー */
	ILLEGAL_REQUEST("WD0003", LogLevel.WARN);

	/** 外部用エラーコード */
	private String outerErrorCode;
	/** ログレベル */
	private LogLevel logLevel;

	private DashboardErrorCode(String outerErrorCode, LogLevel logLevel) {
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
