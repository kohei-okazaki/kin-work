package jp.co.kin.common.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;

/**
 * {@link BeanUtil} のjUnit
 */
public class BeanUtilTest {

	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(BeanUtilTest.class);

	@Test
	public void copyTest() {

		String name = "name";
		int num = 123;
		Date date = new Date();
		{
			LOG.debug("#copyTest");
			CopyBean srcBean = new CopyBean();
			srcBean.setName(name);
			srcBean.setNum(num);
			srcBean.setDate(date);

			CopyBean destBean = new CopyBean();

			BeanUtil.copy(srcBean, destBean);

			assertEquals(srcBean.getName(), destBean.getName());
		}

	}

}
