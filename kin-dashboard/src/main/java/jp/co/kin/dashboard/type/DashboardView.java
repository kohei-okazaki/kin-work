package jp.co.kin.dashboard.type;

import jp.co.kin.common.type.BaseEnum;
import jp.co.kin.web.view.BaseView;

/**
 * 勤怠管理ダッシュボード列挙
 */
public enum DashboardView implements BaseView {

	/** ログイン画面 */
	LOGIN("login/index"),
	/** TOP画面 */
	TOP("login/top"),
	/** ユーザ登録画面 */
	USER_REGIST_INPUT("userregist/input"),
	/** ユーザ登録確認画面 */
	USER_REGIST_CONFIRM("userregist/confirm"),
	/** ユーザ登録完了画面 */
	USER_REGIST_COMPLETE("userregist/complete"),

	/** ユーザ変更画面 */
	USER_CHANGE_INPUT("userchange/input"),
	/** ユーザ変更確認画面 */
	USER_CHANGE_CONFIRM("userchange/confirm"),
	/** ユーザ変更完了画面 */
	USER_CHANGE_COMPLETE("userchange/complete"),

	/** 勤怠登録画面 */
	ATTEND_REGIST_INPUT("attendregist/input"),
	/** 勤怠登録確認画面 */
	ATTEND_REGIST_CONFIRM("attendregist/confirm"),
	/** 勤怠登録完了画面 */
	ATTEND_REGIST_COMPLETE("attendregist/complete"),

	/** 勤怠登録画面 */
	ONTIME_REGIST_INPUT("ontimeregist/input"),
	/** 勤怠登録確認画面 */
	ONTIME_REGIST_CONFIRM("ontimeregist/confirm"),
	/** 勤怠登録完了画面 */
	ONTIME_REGIST_COMPLETE("ontimeregist/complete"),

	/** Error画面 */
	ERROR("error/index");

	private String name;

	private DashboardView(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return getValue();
	}

	@Override
	public String getValue() {
		return this.name;
	}

	public static DashboardView of(String value) {
		return BaseEnum.of(DashboardView.class, value);
	}

}
