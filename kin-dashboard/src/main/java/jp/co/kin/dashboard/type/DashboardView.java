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
