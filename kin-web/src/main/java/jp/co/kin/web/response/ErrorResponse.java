package jp.co.kin.web.response;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jp.co.kin.common.exception.BaseException;
import jp.co.kin.web.type.ResultType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class ErrorResponse extends BaseResponse {

	/** エラーコード */
	private String errorCode;
	/** 詳細 */
	private String detail;

	public ErrorResponse(BaseException e) {
		super.setResultType(ResultType.FAILURE);
		this.detail = e.getDetail();
	}

	/**
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return detail
	 */
	public String getDetail() {
		return detail;
	}

}
