package jp.co.kin.business.db.search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.test.BaseBusinessTest;

/**
 * {@link OntimeMtSearchService} のjUnit
 *
 */
public class OntimeMtSearchServiceTest extends BaseBusinessTest {

	@Autowired
	private OntimeMtSearchService service;

	@Test
	public void searchTest() {
		List<OntimeDto> dtoList = service.search();
		assertNotEquals(0, dtoList.size());
	}

	@Test
	public void searchByCompanyCodeTest() {
		{
			String companyCode = "dummyId";
			OntimeDto dto = service.searchByCompanyCode(companyCode);
			assertEquals(null, dto);
		}
		{
			String companyCode = "00001";
			OntimeDto dto = service.searchByCompanyCode(companyCode);
			assertEquals(companyCode, dto.getCompanyCode());
		}
	}
}
