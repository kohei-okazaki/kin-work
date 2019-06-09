package jp.co.kin.web.controller;

import jp.co.kin.common.type.BaseEnum;

/**
 * 基底Viewコントローラ
 */
public interface BaseViewController {

	public default String getView(BaseEnum view) {
		return view.getValue();
	}

	public default String getRedirectView(BaseEnum view) {
		return "redirect:" + view.getValue();
	}
}
