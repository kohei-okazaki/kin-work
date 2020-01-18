package jp.co.kin.dashboard.attendregist.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.validator.annotation.Length;
import jp.co.kin.common.validator.annotation.Max;
import jp.co.kin.common.validator.annotation.Pattern;
import jp.co.kin.common.validator.annotation.Required;
import jp.co.kin.web.form.BaseForm;

/**
 * 勤怠登録画面form
 *
 * @since 1.0.0
 */
public class AttendRegistForm implements BaseForm {

	/** 年 */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER, message = "年は半角数字です")
	@Length(length = 4, message = "年は4桁です")
	private String year;
	/** 月 */
	@Required
	@Pattern(regixPattern = RegixType.HALF_NUMBER, message = "月は半角数字です")
	@Max(size = 2, isEqual = true)
	private String month;
	/** 1行あたりの勤怠データ */
	@Valid
	private List<AttendRegistUnitForm> registFormList = new ArrayList<>();

	/**
	 * yearを返す
	 *
	 * @return year
	 *
	 */
	public String getYear() {
		return year;
	}

	/**
	 * yearを設定する
	 *
	 * @param year
	 *            year
	 *
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * monthを返す
	 *
	 * @return month
	 *
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * monthを設定する
	 *
	 * @param month
	 *            month
	 *
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * registFormListを返す
	 *
	 * @return registFormList
	 *
	 */
	public List<AttendRegistUnitForm> getRegistFormList() {
		return registFormList;
	}

	/**
	 * registFormListを設定する
	 *
	 * @param registFormList
	 *            registFormList
	 *
	 */
	public void setRegistFormList(List<AttendRegistUnitForm> registFormList) {
		this.registFormList = registFormList;
	}

}
