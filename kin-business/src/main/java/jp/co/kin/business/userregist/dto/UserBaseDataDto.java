package jp.co.kin.business.userregist.dto;

import java.time.LocalDateTime;

import jp.co.kin.common.bean.BaseDto;

/**
 * ユーザ基本情報のDto
 *
 * @since 1.0.0
 */
public class UserBaseDataDto implements BaseDto {

    /** ユーザID */
    private String userId;
    /** 企業コード */
    private String companyCode;
    /** 登録日時 */
    private LocalDateTime regDate;
    /** 更新日時 */
    private LocalDateTime updateDate;

    /**
     * userIdを返す
     *
     * @return userId
     *
     */
    public String getUserId() {
        return userId;
    }

    /**
     * userIdを設定する
     *
     * @param userId
     *     userId
     *
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * companyCodeを返す
     *
     * @return companyCode
     *
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * companyCodeを設定する
     *
     * @param companyCode
     *     companyCode
     *
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * regDateを返す
     *
     * @return regDate
     *
     */
    public LocalDateTime getRegDate() {
        return regDate;
    }

    /**
     * regDateを設定する
     *
     * @param regDate
     *     regDate
     *
     */
    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    /**
     * updateDateを返す
     *
     * @return updateDate
     *
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * updateDateを設定する
     *
     * @param updateDate
     *     updateDate
     *
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
