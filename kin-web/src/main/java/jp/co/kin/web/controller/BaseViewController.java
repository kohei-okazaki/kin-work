package jp.co.kin.web.controller;

import jp.co.kin.web.type.BaseView;

/**
 * 基底Viewコントローラ
 */
public interface BaseViewController {

	public default String getView(BaseView view) {
		return view.getName();
	}

	public default String getRedirectView(BaseView view) {
		return "redirect:" + view.getName();
	}
}
