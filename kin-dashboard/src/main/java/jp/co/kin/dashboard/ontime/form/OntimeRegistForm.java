package jp.co.kin.dashboard.ontime.form;

import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

public class OntimeRegistForm implements BaseForm {

	/** 始業時間 */
	@Required
	private String startTime;
	/** 終業時間 */
	@Required
	private String endTime;

	/**
	 * startTimeを返す
	 *
	 * @return startTime
	 *
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * startTimeを設定する
	 *
	 * @param startTime
	 *            startTime
	 *
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * endTimeを返す
	 *
	 * @return endTime
	 *
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * endTimeを設定する
	 *
	 * @param endTime
	 *            endTime
	 *
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
