package jp.co.kin.business.db.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.login.dto.LoginUserDataDto;
import jp.co.kin.business.test.BaseBusinessTest;

/**
 * {@link LoginUserDataSearchService} のjUnit
 *
 */
public class LoginUserDataSearchServiceTest extends BaseBusinessTest {

    @Autowired
    private LoginUserDataSearchService service;

    @Test
    public void searchByLoginIdTest() {
        {
            String loginId = "dummyId";
            LoginUserDataDto dto = service.searchByLoginId(loginId);
            assertEquals(true, dto == null);
        }
    }

    @Test
    public void searchCountByLoginIdTest() {
        {
            String loginId = "dummyId";
            int count = service.searchCountByLoginId(loginId);
            assertEquals(0, count);
        }
        {
            String loginId = "test";
            int count = service.searchCountByLoginId(loginId);
            assertEquals(1, count);
        }
    }
}
