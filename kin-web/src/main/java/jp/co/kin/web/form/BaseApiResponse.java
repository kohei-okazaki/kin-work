package jp.co.kin.web.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jp.co.kin.web.convert.ResultTypeSerializer;
import jp.co.kin.web.type.ResultType;

/**
 * API基底レスポンス
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public abstract class BaseApiResponse implements BaseForm {

	/** API結果コード */
	@JsonSerialize(using = ResultTypeSerializer.class)
	@JsonProperty("result")
	private ResultType resultType;

	public BaseApiResponse() {
		this.resultType = ResultType.SUCCESS;
	}

	/**
	 * resultTypeを返す
	 *
	 * @return resultType
	 */
	public ResultType getResultType() {
		return resultType;
	}

	/**
	 * resultTypeを設定する
	 *
	 * @param resultType
	 *            API結果コード
	 */
	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

}
