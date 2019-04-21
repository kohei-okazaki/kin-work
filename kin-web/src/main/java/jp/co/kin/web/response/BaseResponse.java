package jp.co.kin.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jp.co.kin.web.type.ResultType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public abstract class BaseResponse {

	@JsonProperty(value = "result")
	private ResultType resultType;

	/**
	 * resultTypeを返す
	 *
	 * @return resultType
	 *
	 */
	public ResultType getResultType() {
		return resultType;
	}

	/**
	 * @param resultType
	 *            resultTypeを設定する
	 *
	 */
	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}
}
