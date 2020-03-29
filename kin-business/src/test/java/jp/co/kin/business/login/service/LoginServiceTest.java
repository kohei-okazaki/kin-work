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
    public void successTest() {
        LoginUserDataDto dto = new LoginUserDataDto();
        dto.setLoginId("test");
        dto.setPassword("test");
        LoginCheckResult result = service.checkLogin(dto);
        assertEquals(false, result.hasError());
    }

    @Test
    public void notFoundLoginIdTest() {
        LoginUserDataDto dto = new LoginUserDataDto();
        dto.setLoginId("dummyId");
        LoginCheckResult result = service.checkLogin(dto);
        assertEquals(true, result.hasError());
        assertEquals("validate.login.loginIdNoExist", result.getMessage());
    }

    @Test
    public void notEqualPassword() {
        LoginUserDataDto dto = new LoginUserDataDto();
        dto.setLoginId("test");
        dto.setPassword("hoge");
        LoginCheckResult result = service.checkLogin(dto);
        assertEquals(true, result.hasError());
        assertEquals("validate.login.inValidPassword", result.getMessage());
    }

}
