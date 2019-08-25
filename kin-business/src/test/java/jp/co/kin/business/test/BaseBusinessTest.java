package jp.co.kin.business.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@ContextConfiguration(locations = { "classpath:common-context.xml", "classpath:db-context.xml",
		"classpath:business-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseBusinessTest {

}
