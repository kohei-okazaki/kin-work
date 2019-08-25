package jp.co.kin.common.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
