package jp.co.kin.common.io.file.csv.dto;

import jp.co.kin.common.bean.BaseDto;

/**
 * CSVへの書き込み結果を保持するクラス
 *
 * @since 1.0.0
 */
public class CsvWriteResult implements BaseDto {

    private boolean hasError;
    private String errorMessage;

    /**
     * hasErrorを返す
     *
     * @return hasError
     *
     */
    public boolean isHasError() {
        return hasError;
    }

    /**
     * hasErrorを設定する
     *
     * @param hasError
     *     hasError
     *
     */
    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    /**
     * errorMessageを返す
     *
     * @return errorMessage
     *
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * errorMessageを設定する
     *
     * @param errorMessage
     *     errorMessage
     *
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
