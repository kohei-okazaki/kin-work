package jp.co.kin.common.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;

/**
 * commonプロジェクトの基底テストクラス<br>
 * 以下の設定ファイルを読み込む
 * <ul>
 * <li>common-context.xml</li>
 * </ul>
 *
 */
@ContextConfiguration(locations = { "classpath:common-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseCommonTest {

	private static final Logger LOG = LoggerFactory.getLogger(BaseCommonTest.class);

	@Before
	public void before() {
		LOG.debug("BaseCommonTest start");
	}

	@After
	public void after() {
		LOG.debug("BaseCommonTest end");
	}
}
