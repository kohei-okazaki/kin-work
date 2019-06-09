package jp.co.kin.common.exception;

import jp.co.kin.common.log.type.LogLevel;

/**
 * エラーコードの基底インターフェース
 */
public interface BaseErrorCode {

	/**
	 * エラーコード(外部用)を返却
	 *
	 * @return
	 */
	String getOuterErrorCode();

	/**
	 * ログレベルを返却
	 *
	 * @return
	 */
	LogLevel getLogLevel();

}
