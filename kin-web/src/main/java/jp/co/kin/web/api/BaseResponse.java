package jp.co.kin.web.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jp.co.kin.web.api.type.ResultType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public abstract class BaseResponse {

	@JsonProperty(value = "result")
	private ResultType resultType;

	/**
	 * @return resultType
	 */
	public ResultType getResultType() {
		return resultType;
	}

	/**
	 * @param resultType セットする resultType
	 */
	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

}
