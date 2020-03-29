package jp.co.kin.db.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.db.entity.OntimeMt;
import jp.co.kin.db.test.BaseDbTest;

/**
 * {@link OntimeMtDao} のjUnit
 *
 */
public class OntimeMtDaoTest extends BaseDbTest {

    @Autowired
    private OntimeMtDao dao;

    @Test
    public void selectByIdTest() {
        {
            // entityが存在する場合
            String id = "00001";
            OntimeMt entity = dao.selectById(id);
            assertEquals(id, entity.getCompanyCode());
        }
        {
            // entityが存在しない場合
            String id = "dummyId";
            OntimeMt entity = dao.selectById(id);
            assertEquals(null, entity);
        }
    }
}
