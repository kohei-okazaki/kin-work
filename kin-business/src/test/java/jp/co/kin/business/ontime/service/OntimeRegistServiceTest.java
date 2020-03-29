package jp.co.kin.business.ontime.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.business.ontime.dto.OntimeDto;
import jp.co.kin.business.test.BaseBusinessTest;

/**
 * {@link OntimeRegistService} のjUnit
 *
 */
public class OntimeRegistServiceTest extends BaseBusinessTest {

    @Autowired
    private OntimeRegistService service;

    @Test
    public void registTest() {
        {
            OntimeDto dto = new OntimeDto();
            dto.setCompanyCode("99999");
            dto.setWorkStartHour("01");
            dto.setWorkStartMinute("02");
            dto.setWorkEndHour("03");
            dto.setWorkEndMinute("04");
            service.regist(dto);
        }
    }
}
