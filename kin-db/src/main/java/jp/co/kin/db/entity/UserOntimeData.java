package jp.co.kin.db.entity;

import java.util.Date;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class UserOntimeData extends BaseEntity {

	/** ログインID */
	@Id
	private String loginId;
	/** 始業時間(時) */
	private String workStartTimeHour;
	/** 始業時間(分) */
	private String workStartTimeMinute;
	/** 終業時間(時) */
	private String workEndTimeHour;
	/** 終業時間(分) */
	private String workEndTimeMinute;
	/** 登録日時 */
	private Date regDate;
	/** 更新日時 */
	private Date updateDate;

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setWorkStartTimeHour(String workStartTimeHour) {
		this.workStartTimeHour = workStartTimeHour;
	}

	public String getWorkStartTimeHour() {
		return workStartTimeHour;
	}

	public void setWorkStartTimeMinute(String workStartTimeMinute) {
		this.workStartTimeMinute = workStartTimeMinute;
	}

	public String getWorkStartTimeMinute() {
		return workStartTimeMinute;
	}

	public void setWorkEndTimeHour(String workEndTimeHour) {
		this.workEndTimeHour = workEndTimeHour;
	}

	public String getWorkEndTimeHour() {
		return workEndTimeHour;
	}

	public void setWorkEndTimeMinute(String workEndTimeMinute) {
		this.workEndTimeMinute = workEndTimeMinute;
	}

	public String getWorkEndTimeMinute() {
		return workEndTimeMinute;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

}
