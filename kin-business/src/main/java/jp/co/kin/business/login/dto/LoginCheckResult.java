package jp.co.kin.business.login.dto;

import jp.co.kin.common.bean.BaseDto;

public class LoginCheckResult implements BaseDto {

	private boolean hasError;
	private String errorField;
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
