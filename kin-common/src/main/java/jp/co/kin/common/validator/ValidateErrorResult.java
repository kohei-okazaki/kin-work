package jp.co.kin.common.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import jp.co.kin.common.util.CollectionUtil;

/**
 * 妥当性チェック結果情報保持クラス
 *
 * @since 1.0.0
 */
public class ValidateErrorResult {

    private List<ValidateError> resultList;

    public ValidateErrorResult() {
        this.resultList = new ArrayList<>();
    }

    /**
     * エラー保持している場合、true
     *
     * @return エラー保持している場合、true
     */
    public boolean hasError() {
        return CollectionUtil.exists(resultList);
    }

    /**
     * validateエラーを追加する
     *
     * @param error
     *     validate時に発生したエラー
     */
    public void addError(ValidateError error) {
        this.resultList.add(error);
    }

    /**
     * エラーを返す
     *
     * @param supplier
     *     エラー位置
     * @return 妥当性エラー
     */
    public ValidateError get(Supplier<Integer> supplier) {
        return this.resultList.get(supplier.get().intValue());
    }

    /**
     * エラーを返す
     *
     * @return 妥当性エラー
     */
    public ValidateError get() {
        return this.get(() -> Integer.valueOf(0));
    }

    /**
     * 妥当性チェックエラー情報クラス
     *
     * @since 1.0.0
     */
    public static class ValidateError {

        /** フィールド名 */
        private String name;
        /** エラーメッセージ */
        private String message;
        /** 値 */
        private String value;

        /**
         * nameを返す
         *
         * @return name
         *
         */
        public String getName() {
            return name;
        }

        /**
         * nameを設定する
         *
         * @param name
         *     name
         *
         */
        public void setName(String name) {
            this.name = name;
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
         *     message
         *
         */
        public void setMessage(String message) {
            this.message = message;
        }

        /**
         * valueを返す
         *
         * @return value
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * valueを設定する
         *
         * @param value
         *     value
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

    }
}
