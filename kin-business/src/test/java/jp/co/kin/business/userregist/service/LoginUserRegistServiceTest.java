package jp.co.kin.business.userregist.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.test.BaseBusinessTest;
import jp.co.kin.business.userregist.dto.UserRegistDto;

/**
 * {@link LoginUserRegistService} のjUnit
 *
 */
public class LoginUserRegistServiceTest extends BaseBusinessTest {

    @Autowired
    private LoginUserRegistService service;

    @Test
    public void registTest() {
        {
            // TODO 要実装
        }
    }

    @Test
    public void isDuplicateLoginIdTest() {
        {
            UserRegistDto dto = new UserRegistDto();
            dto.setLoginId("dummyId");
            assertEquals(false, service.isDuplicateLoginId(dto));
        }
        {
            UserRegistDto dto = new UserRegistDto();
            dto.setLoginId("test");
            assertEquals(false, service.isDuplicateLoginId(dto));
        }
    }
}
