package jp.co.kin.business.userregist.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.login.type.UserAuth;
import jp.co.kin.business.test.BaseBusinessTest;

/**
 * {@link UserBusinessProperties} のjUnit
 *
 */
public class UserBusinessPropertiesTest extends BaseBusinessTest {

	@Autowired
	private UserBusinessProperties prop;

	@Test
	public void valueTest() {
		{
			assertEquals(LocalDateTime.of(9999, 12, 31, 0, 0, 0), prop.getAuthDate());
			assertEquals(UserAuth.COMMON, prop.getUserAuth());
		}
	}

}
