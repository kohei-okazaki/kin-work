package jp.co.kin.db.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 日別ユーザ勤怠情報 Entity
 *
 */
@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class DailyUserWorkData extends BaseEntity {

	/** 日別勤怠データID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal dailyUserWorkDataId;
	/** ユーザID */
	private String userId;
	/** 企業コード */
	private String companyCode;
	/** 勤怠情報登録日時 */
	private LocalDate workDataRegDate;
	/** 始業日時 */
	private LocalDateTime workStartDate;
	/** 終業日時 */
	private LocalDateTime workEndDate;
	/** 実労働時間 */
	private String actualWorkTime;
	/** 登録日時 */
	private LocalDateTime regDate;
	/** 更新日時 */
	private LocalDateTime updateDate;

	public void setDailyUserWorkDataId(BigDecimal dailyUserWorkDataId) {
		this.dailyUserWorkDataId = dailyUserWorkDataId;
	}

	public BigDecimal getDailyUserWorkDataId() {
		return dailyUserWorkDataId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setWorkDataRegDate(LocalDate workDataRegDate) {
		this.workDataRegDate = workDataRegDate;
	}

	public LocalDate getWorkDataRegDate() {
		return workDataRegDate;
	}

	public void setWorkStartDate(LocalDateTime workStartDate) {
		this.workStartDate = workStartDate;
	}

	public LocalDateTime getWorkStartDate() {
		return workStartDate;
	}

	public void setWorkEndDate(LocalDateTime workEndDate) {
		this.workEndDate = workEndDate;
	}

	public LocalDateTime getWorkEndDate() {
		return workEndDate;
	}

	public void setActualWorkTime(String actualWorkTime) {
		this.actualWorkTime = actualWorkTime;
	}

	public String getActualWorkTime() {
		return actualWorkTime;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

}
