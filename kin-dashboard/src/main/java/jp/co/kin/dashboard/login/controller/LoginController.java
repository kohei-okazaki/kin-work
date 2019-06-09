package jp.co.kin.dashboard.login.controller;

import org.springframework.stereotype.Controller;

import jp.co.kin.dashboard.type.DashboardView;
import jp.co.kin.web.controller.BaseViewController;

/**
 * ログインコントローラ
 */
@Controller
public class LoginController implements BaseViewController {

	public String index() {
		return getView(DashboardView.LOGIN);
	}
}
