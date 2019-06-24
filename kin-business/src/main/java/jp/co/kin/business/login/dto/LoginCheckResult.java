package jp.co.kin.business.login.dto;

import jp.co.kin.common.bean.BaseDto;

/**
 * ログインチェック情報保持クラス
 *
 */
public class LoginCheckResult implements BaseDto {

	/** エラー発生有無 */
	private boolean hasError;
	/** エラー対象のフィールド */
	private String errorField;
	/** エラーメッセージ */
	private String message;

	/**
	 * hasErrorを返す
	 *
	 * @return hasError
	 *
	 */
	public boolean hasError() {
		return hasError;
	}

	/**
	 * hasErrorを設定する
	 *
	 * @param hasError
	 *            hasError
	 *
	 */
	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	/**
	 * errorFieldを返す
	 *
	 * @return errorField
	 *
	 */
	public String getErrorField() {
		return errorField;
	}

	/**
	 * errorFieldを設定する
	 *
	 * @param errorField
	 *            errorField
	 *
	 */
	public void setErrorField(String errorField) {
		this.errorField = errorField;
	}

	/**
	 * messageを返す
	 *
	 * @return message
	 *
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * messageを設定する
	 *
	 * @param message
	 *            message
	 *
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
