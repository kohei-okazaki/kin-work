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
	private String workStartHour;
	/** 始業時間(分) */
	private String workStartMinute;
	/** 終業時間(時) */
	private String workEndHour;
	/** 終業時間(分) */
	private String workEndMinute;
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

	public void setWorkStartHour(String workStartHour) {
		this.workStartHour = workStartHour;
	}

	public String getWorkStartHour() {
		return workStartHour;
	}

	public void setWorkStartMinute(String workStartMinute) {
		this.workStartMinute = workStartMinute;
	}

	public String getWorkStartMinute() {
		return workStartMinute;
	}

	public void setWorkEndHour(String workEndHour) {
		this.workEndHour = workEndHour;
	}

	public String getWorkEndHour() {
		return workEndHour;
	}

	public void setWorkEndMinute(String workEndMinute) {
		this.workEndMinute = workEndMinute;
	}

	public String getWorkEndMinute() {
		return workEndMinute;
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
