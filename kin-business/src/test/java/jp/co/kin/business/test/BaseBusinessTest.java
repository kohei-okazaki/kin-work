package jp.co.kin.business.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jp.co.kin.common.bean.BeanFactory;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;

/**
 * businessプロジェクトの基底テストクラス<br>
 * 以下の設定ファイルを読み込む
 * <ul>
 * <li>common-context.xml</li>
 * <li>db-context.xml</li>
 * <li>business-context.xml</li>
 * </ul>
 *
 */
@ContextConfiguration(locations = { "classpath:common-context.xml",
        "classpath:db-context.xml", "classpath:business-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseBusinessTest {

    private static final Logger LOG = LoggerFactory.getLogger(BaseBusinessTest.class);

    @Before
    public void before() {
        LOG.debug("BaseBusinessTest start");
        BeanFactory.setContext(
                new ClassPathXmlApplicationContext("classpath:common-context.xml",
                        "classpath:db-context.xml", "classpath:business-context.xml"));
    }

    @After
    public void after() {
        LOG.debug("BaseBusinessTest end");
    }

}
