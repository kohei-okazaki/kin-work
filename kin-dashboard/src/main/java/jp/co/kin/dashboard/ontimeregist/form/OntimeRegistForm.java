package jp.co.kin.dashboard.ontimeregist.form;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.validator.annotation.Length;
import jp.co.kin.common.validator.annotation.Pattern;
import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

/**
 * 定時情報登録画面のForm
 * 
 * @since 1.0.0
 *
 */
public class OntimeRegistForm implements BaseForm {

	/** 企業コード */
	@Required
	@Pattern(regixPattern = RegixType.HALF_CHAR, message = "企業コードは半角英数字です")
	@Length(length = 5, message = "企業コードは5桁です")
	private String companyCode;
	/** 始業時間(時) */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER, message = "始業時間(時)は半角数字です")
	@Length(length = 2, message = "始業時間(時)は2桁です")
	private String workStartHour;
	/** 始業時間(分) */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER, message = "始業時間(分)は半角数字です")
	@Length(length = 2, message = "始業時間(分)は2桁です")
	private String workStartMinute;
	/** 終業時間(時) */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER, message = "終業時間(時)は半角数字です")
	@Length(length = 2, message = "終業時間(時)は2桁です")
	private String workEndHour;
	/** 終業時間(分) */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER, message = "終業時間(分)は半角数字です")
	@Length(length = 2, message = "終業時間(分)は2桁です")
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
