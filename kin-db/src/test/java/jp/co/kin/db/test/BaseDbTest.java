package jp.co.kin.db.test;

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
 * dbプロジェクトの基底テストクラス<br>
 * 以下の設定ファイルを読み込む
 * <ul>
 * <li>common-context.xml</li>
 * <li>db-context.xml</li>
 * </ul>
 *
 */
@ContextConfiguration(locations = { "classpath:common-context.xml", "classpath:db-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseDbTest {

	private static final Logger LOG = LoggerFactory.getLogger(BaseDbTest.class);

	@Before
	public void before() {
		LOG.debug("BaseDbTest start");
		BeanFactory.setContext(new ClassPathXmlApplicationContext("classpath:common-context.xml",
				"classpath:db-context.xml"));
	}

	@After
	public void after() {
		LOG.debug("BaseDbTest end");
	}
}
