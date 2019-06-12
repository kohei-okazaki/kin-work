package jp.co.kin.dashboard.type;

import jp.co.kin.web.view.BaseView;

/**
 * 勤怠管理ダッシュボード列挙
 */
public enum DashboardView implements BaseView {

	/** ログイン画面 */
	LOGIN("login/index"),
	/** TOP画面 */
	TOP("login/top");

	private String name;

	private DashboardView(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
