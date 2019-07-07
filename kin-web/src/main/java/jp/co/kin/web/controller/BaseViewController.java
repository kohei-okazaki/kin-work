package jp.co.kin.web.controller;

import jp.co.kin.common.util.StringUtil;
import jp.co.kin.web.view.BaseView;

/**
 * 基底Viewコントローラ
 */
public interface BaseViewController extends BaseController {

	public default String getView(BaseView view) {
		return view.getName();
	}

	public default String getRedirectView(BaseView view) {
		return "redirect:" + view.getName().split(StringUtil.THRASH)[1];
	}
}
