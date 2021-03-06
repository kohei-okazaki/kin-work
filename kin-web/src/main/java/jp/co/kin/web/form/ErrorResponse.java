package jp.co.kin.web.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jp.co.kin.common.exception.BaseException;

/**
 * Errorレスポンスクラス
 *
 * @since 1.0.0
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class ErrorResponse extends BaseApiResponse {

    /** 外部エラーコード */
    @JsonProperty("errorCode")
    private String outerErrorCode;
    /** 詳細 */
    @JsonProperty("detail")
    private String detail;

    /**
     * コンストラクタ
     *
     * @param e
     *     例外
     */
    public ErrorResponse(BaseException e) {
        super.setResultType(ResultType.FAILURE);
        this.outerErrorCode = e.getErrorCode().getOuterErrorCode();
        this.detail = e.getDetail();
    }

    /**
     * outerErrorCodeを返す
     *
     * @return outerErrorCode
     */
    public String getOuterErrorCode() {
        return outerErrorCode;
    }

    /**
     * outerErrorCodeを設定する
     *
     * @param outerErrorCode
     *     外部エラーコード
     */
    public void setOuterErrorCode(String outerErrorCode) {
        this.outerErrorCode = outerErrorCode;
    }

    /**
     * detailを返す
     *
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * detailを設定する
     *
     * @param detail
     *     詳細
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

}
