package jp.co.kin.db.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.db.entity.DailyUserWorkData;
import jp.co.kin.db.test.BaseDbTest;

/**
 * {@link DailyUserWorkDataDao} のjUnit
 *
 */
public class DailyUserWorkDataDaoTest extends BaseDbTest {

	@Autowired
	private DailyUserWorkDataDao dao;

	@Test
	public void selectByWorkDateTest() {
		{
			// entityが存在しない場合
			LocalDate from = LocalDate.of(2019, 1, 1);
			LocalDate to = LocalDate.of(2019, 1, 2);
			String id = "dummyId";
			List<DailyUserWorkData> entityList = dao.selectByWorkDate(from, to, id);
			assertEquals(0, entityList.size());
		}
		{
			// entityが存在しない場合(fromとtoを入れ替えた)
			LocalDate from = LocalDate.of(2019, 1, 1);
			LocalDate to = LocalDate.of(2019, 1, 2);
			String id = "dummyId";
			List<DailyUserWorkData> entityList = dao.selectByWorkDate(to, from, id);
			assertEquals(0, entityList.size());
		}
	}

}
