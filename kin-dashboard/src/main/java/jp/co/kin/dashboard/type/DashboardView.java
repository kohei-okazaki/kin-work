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
	/** ログインユーザ登録画面 */
	USER_REGIST_INPUT("userRegist/input"),
	/** ログインユーザ登録確認画面 */
	USER_REGIST_CONFIRM("userRegist/confirm"),
	/** ログインユーザ登録完了画面 */
	USER_REGIST_COMPLETE("userRegist/complete"),

	/** 勤怠登録画面 */
	ATTEND_REGIST_INPUT("attendRegist/input"),
	/** 勤怠登録確認画面 */
	ATTEND_REGIST_CONFIRM("attendRegist/confirm"),
	/** 勤怠登録完了画面 */
	ATTEND_REGIST_COMPLETE("attendRegist/complete"),

	/** 勤怠登録画面 */
	ONTIME_REGIST_INPUT("ontimeRegist/input"),
	/** 勤怠登録確認画面 */
	ONTIME_REGIST_CONFIRM("ontimeRegist/confirm"),
	/** 勤怠登録完了画面 */
	ONTIME_REGIST_COMPLETE("ontimeRegist/complete"),

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
