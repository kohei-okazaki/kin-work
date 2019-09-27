package jp.co.kin.dashboard.ontimeregist.form;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.validator.annotation.Length;
import jp.co.kin.common.validator.annotation.Pattern;
import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

public class OntimeRegistForm implements BaseForm {

	/** 企業コード */
	@Required
	@Pattern(regixPattern = RegixType.HALF_CHAR)
	@Length(length = 5)
	private String companyCode;
	/** 始業時間(時) */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER)
	@Length(length = 2)
	private String workStartHour;
	/** 始業時間(分) */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER)
	@Length(length = 2)
	private String workStartMinute;
	/** 終業時間(時) */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER)
	@Length(length = 2)
	private String workEndHour;
	/** 終業時間(分) */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER)
	@Length(length = 2)
	private String workEndMinute;

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
	 *            companyCode
	 *
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * workStartHourを返す
	 *
	 * @return workStartHour
	 *
	 */
	public String getWorkStartHour() {
		return workStartHour;
	}

	/**
	 * workStartHourを設定する
	 *
	 * @param workStartHour
	 *            workStartHour
	 *
	 */
	public void setWorkStartHour(String workStartHour) {
		this.workStartHour = workStartHour;
	}

	/**
	 * workStartMinuteを返す
	 *
	 * @return workStartMinute
	 *
	 */
	public String getWorkStartMinute() {
		return workStartMinute;
	}

	/**
	 * workStartMinuteを設定する
	 *
	 * @param workStartMinute
	 *            workStartMinute
	 *
	 */
	public void setWorkStartMinute(String workStartMinute) {
		this.workStartMinute = workStartMinute;
	}

	/**
	 * workEndHourを返す
	 *
	 * @return workEndHour
	 *
	 */
	public String getWorkEndHour() {
		return workEndHour;
	}

	/**
	 * workEndHourを設定する
	 *
	 * @param workEndHour
	 *            workEndHour
	 *
	 */
	public void setWorkEndHour(String workEndHour) {
		this.workEndHour = workEndHour;
	}

	/**
	 * workEndMinuteを返す
	 *
	 * @return workEndMinute
	 *
	 */
	public String getWorkEndMinute() {
		return workEndMinute;
	}

	/**
	 * workEndMinuteを設定する
	 *
	 * @param workEndMinute
	 *            workEndMinute
	 *
	 */
	public void setWorkEndMinute(String workEndMinute) {
		this.workEndMinute = workEndMinute;
	}

}
