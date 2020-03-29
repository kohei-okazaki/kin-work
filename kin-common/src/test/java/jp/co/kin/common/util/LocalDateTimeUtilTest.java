package jp.co.kin.common.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.Test;

import jp.co.kin.common.test.BaseCommonTest;

/**
 * {@link LocalDateTimeUtil} のjUnit
 *
 */
public class LocalDateTimeUtilTest extends BaseCommonTest {

    @Test
    public void getLastDayOfMonthTest() {
        {
            // 2019/01/01 0:00:00を取得
            LocalDateTime date = LocalDateTime.of(2019, 1, 1, 0, 0, 0);
            int last = LocalDateTimeUtil.getLastDayOfMonth(date);
            assertEquals(31, last);
        }
        {
            // 2020/04/01 0:00:00を取得
            LocalDateTime date = LocalDateTime.of(2020, 4, 1, 0, 0, 0);
            int last = LocalDateTimeUtil.getLastDayOfMonth(date);
            assertEquals(30, last);
        }
        {
            // 2019/02/01 0:00:00を取得
            LocalDateTime date = LocalDateTime.of(2019, 2, 1, 0, 0, 0);
            int last = LocalDateTimeUtil.getLastDayOfMonth(date);
            assertEquals(28, last);
        }
        {
            // 2020/02/01 0:00:00を取得
            LocalDateTime date = LocalDateTime.of(2020, 2, 1, 0, 0, 0);
            int last = LocalDateTimeUtil.getLastDayOfMonth(date);
            assertEquals(29, last);
        }

    }
}
