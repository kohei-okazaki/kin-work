package jp.co.kin.business.login.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.kin.business.db.search.LoginUserDataSearchService;
import jp.co.kin.business.db.update.LoginUserDataUpdateService;
import jp.co.kin.business.login.dto.LoginCheckResult;
import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.business.login.service.LoginService;
import jp.co.kin.business.login.type.AccountLockFlg;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.LocalDateTimeUtil;
import jp.co.kin.db.entity.LoginUserData;

/**
 * ログイン処理サービス実装クラス
 *
 * @since 1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService {

	/** ログインユーザ情報検索サービス */
	@Autowired
	private LoginUserDataSearchService searchService;
	/** ログインユーザ情報更新サービス */
	@Autowired
	private LoginUserDataUpdateService updateService;

	@Override
	public LoginCheckResult checkLogin(LoginUserDataDto dto) {

		LoginUserDataDto searchDto = searchService.searchByLoginId(dto.getLoginId());
		LoginCheckResult result = new LoginCheckResult();

		if (BeanUtil.isNull(searchDto)) {
			result.setHasError(true);
			result.setMessage("validate.login.loginIdNoExist");
		} else if (!searchDto.getPassword().equals(dto.getPassword())) {
			result.setHasError(true);
			result.setMessage("validate.login.inValidPassword");
		} else if (LocalDateTimeUtil.isBefore(searchDto.getPasswordExpire(), LocalDateTimeUtil.getSysDate(),
				false)) {
			result.setHasError(true);
			result.setMessage("validate.login.expired");
		} else if (AccountLockFlg.UNUSABLE == AccountLockFlg.of(searchDto.getAccountLockFlg())) {
			result.setHasError(true);
			result.setMessage("validate.login.accountLock");
		}

		if (BeanUtil.notNull(searchDto)) {
			BeanUtil.copy(searchDto, dto);
		}

		return result;
	}

	@Override
	public void updateFailLoginUserData(LoginUserDataDto dto) {

		LoginUserData entity = new LoginUserData();
		// ログイン失敗回数をインクリメント
		BigDecimal tmp = dto.getLoginFailCount() == null ? BigDecimal.ZERO : dto.getLoginFailCount();
		dto.setLoginFailCount(BigDecimal.ONE.add(tmp));
		BeanUtil.copy(dto, entity);

		if (new BigDecimal(3).equals(entity.getLoginFailCount())) {
			// アカウントロックも行う
			entity.setAccountLockFlg(AccountLockFlg.UNUSABLE.getValue());
			updateService.updateAccountLock(entity);
		} else {
			updateService.updateFailCount(entity);
		}
	}

	@Override
	public void updateClearloginFailCount(LoginUserDataDto dto) {

		LoginUserData entity = new LoginUserData();

		dto.setLoginFailCount(BigDecimal.ZERO);
		BeanUtil.copy(dto, entity);

		updateService.updateFailCount(entity);
	}

}
