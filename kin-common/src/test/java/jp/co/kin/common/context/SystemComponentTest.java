package jp.co.kin.common.context;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.kin.common.log.type.LogLevel;
import jp.co.kin.common.test.BaseCommonTest;

/**
 * {@link SystemComponent} のjUnit
 *
 */
public class SystemComponentTest extends BaseCommonTest {

    @Autowired
    private SystemComponent systemComponent;

    @Test
    public void valueTest() {
        // paging
        assertEquals(Integer.valueOf(systemComponent.getPaging()), 10);

        // loglevel
        assertEquals(systemComponent.getLoglevel(), LogLevel.of("DEBUG"));
    }
}
