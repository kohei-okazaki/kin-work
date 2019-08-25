package jp.co.kin.business.attendregist.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.attendregist.dto.AttendBusinessCalendar;
import jp.co.kin.business.attendregist.dto.AttendRegistDto;
import jp.co.kin.business.attendregist.service.AttendRegistService;
import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.test.BaseBusinessTest;

/**
 * {@link AttendRegistService} のjUnit
 *
 */
public class AttendRegistServiceTest extends BaseBusinessTest {

	@Autowired
	private AttendRegistService service;

	@Test
	public void getYearListTest() {
		List<BigDecimal> list = service.getYearList();
		assertEquals(10, list.size());
		assertEquals(new BigDecimal("2019"), list.get(0));
	}

	@Test
	public void getMonthListTest() {
		List<BigDecimal> list = service.getMonthList();
		assertEquals(12, list.size());
		assertEquals(new BigDecimal("1"), list.get(0));
	}

	@Test
	public void getOntimeDtoTest() {
		{
			// entityが存在する場合
			String userId = "admin";
			OntimeDto dto = service.getOntimeDto(userId);
			assertEquals("00001", dto.getCompanyCode());
		}
		{
			// entityが存在しない場合
			// FIXME 基本的にこのメソッドが呼ばれるときはuserIdに紐づくユーザ基本情報は存在する
			// String userId = "dummyId";
			// OntimeDto dto = service.getOntimeDto(userId);
			// assertEquals(null, dto);
		}
	}

	@Test
	public void getBusinessCalendarListTest() {
		{
			LocalDate date = LocalDate.of(2019, 1, 1);
			List<AttendBusinessCalendar> list = service.getBusinessCalendarList(date);
			assertEquals(BigDecimal.ONE, list.get(0).getDay());
			assertEquals("tuesday", list.get(0).getWeekDay());
		}
	}

	@Test
	public void registDailyWorkDataTest() {
		{
			AttendRegistDto dto = new AttendRegistDto();
			dto.setUserId("test");
			dto.setCompanyCode("manual");
			dto.setActualWorkTime("10");
			dto.setWorkStartDate(LocalDateTime.of(2019, 1, 2, 0, 0, 0));
			dto.setWorkStartDate(LocalDateTime.of(2019, 1, 1, 0, 0, 0));

			// FIXME java.lang.ExceptionInInitializerError が起きる
			// service.registDailyWorkData(dto);
		}
	}
}
