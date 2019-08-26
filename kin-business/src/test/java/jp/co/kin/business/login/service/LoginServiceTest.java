package jp.co.kin.business.login.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.login.dto.LoginCheckResult;
import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.business.test.BaseBusinessTest;

/**
 * {@link LoginService} のjUnit
 *
 */
public class LoginServiceTest extends BaseBusinessTest {

	@Autowired
	private LoginService service;

	@Test
	public void checkLoginTest() {
		{
			// TODO BeanFactory#getContextでエラーになる
			// LOGIN_USER_DATAが存在しない場合
			LoginUserDataDto dto = new LoginUserDataDto();
			dto.setLoginId("dummyId");
			LoginCheckResult result = service.checkLogin(dto);
			assertEquals(true, result.hasError());
			assertEquals("validate.login.loginIdNoExist", result.getMessage());
		}
		{
			// TODO BeanFactory#getContextでエラーになる
			// LOGIN_USER_DATAが存在する場合
			LoginUserDataDto dto = new LoginUserDataDto();
			dto.setLoginId("test");
			LoginCheckResult result = service.checkLogin(dto);
			assertEquals(false, result.hasError());
		}
	}
}
