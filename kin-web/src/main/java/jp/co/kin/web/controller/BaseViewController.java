package jp.co.kin.web.controller;

import jp.co.kin.common.util.StringUtil;
import jp.co.kin.web.view.BaseView;

/**
 * 基底Viewコントローラ
 *
 * @since 1.0.0
 */
public interface BaseViewController extends BaseController {

    /**
     * 画面Viewを返す
     *
     * @param view
     *     画面View
     * @return 画面View
     */
    public default String getView(BaseView view) {
        return view.getName();
    }

    /**
     * 画面ViewをRedirectする
     *
     * @param view
     *     画面View
     * @return RedirectView
     */
    public default String getRedirectView(BaseView view) {
        return "redirect:" + view.getName().split(StringUtil.THRASH)[1];
    }

    /**
     * 画面ViewをForwardする
     *
     * @param view
     *     画面View
     * @return ForwardView
     */
    public default String getForwardView(BaseView view) {
        return "forward:" + view.getName().split(StringUtil.THRASH)[1];
    }

}
