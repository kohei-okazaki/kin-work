package jp.co.kin.dashboard.attendregist.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import jp.co.kin.web.form.BaseForm;

/**
 * 勤怠登録画面form
 *
 */
public class AttendRegistForm implements BaseForm {

	/** 1行あたりの勤怠データ */
	@Valid
	private List<AttendRegistUnitForm> registFormList;

	public AttendRegistForm() {
		this.registFormList = new ArrayList<>();
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
