package jp.co.kin.business.db.search;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.attendregist.dto.AttendRegistDto;
import jp.co.kin.business.test.BaseBusinessTest;

/**
 * {@link DailyUserWorkDataSearchService} のjUnit
 *
 */
public class DailyUserWorkDataSearchServiceTest extends BaseBusinessTest {

	@Autowired
	private DailyUserWorkDataSearchService service;

	@Test
	public void searchListTest() {

		{
			String userId = "dummyId";
			LocalDate targetDate = LocalDate.of(2019, 1, 1);
			List<AttendRegistDto> list = service.searchList(userId, targetDate);
			assertEquals(0, list.size());
		}

	}
}
