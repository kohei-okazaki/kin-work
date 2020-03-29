package jp.co.kin.web.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jp.co.kin.common.type.BaseEnum;
import jp.co.kin.web.convert.ResultTypeSerializer;

/**
 * API基底レスポンス
 *
 * @since 1.0.0
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public abstract class BaseApiResponse implements BaseForm {

    /** API結果コード */
    @JsonSerialize(using = ResultTypeSerializer.class)
    @JsonProperty("result")
    private ResultType resultType = ResultType.SUCCESS;

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
     *     API結果コード
     */
    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    /**
     * Webリクエストの処理結果の列挙
     *
     * @since 1.0.0
     */
    public static enum ResultType implements BaseEnum {

        /** SUCCESS */
        SUCCESS("0", "成功"),
        /** FAILURE */
        FAILURE("1", "失敗");

        /** 値 */
        private String value;
        /** メッセージ */
        private String message;

        private ResultType(String value, String message) {
            this.value = value;
            this.message = message;
        }

        @Override
        public String getValue() {
            return this.value;
        }

        public String getMessage() {
            return this.message;
        }

        public static ResultType of(String value) {
            return BaseEnum.of(ResultType.class, value);
        }

    }

}
