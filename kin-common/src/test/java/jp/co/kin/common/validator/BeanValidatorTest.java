package jp.co.kin.common.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.validator.annotation.Required;

/**
 * {@link BeanValidator} のjUnit
 */
public class BeanValidatorTest {

	/** LOG */
	private final static Logger LOG = LoggerFactory.getLogger(BeanValidatorTest.class);

	@Test
	public void requiredTest() {

		{
			LOG.debug("#requiredTest");
			RequiredTestBean bean = new RequiredTestBean();

			ValidateErrorResult result = new BeanValidator<RequiredTestBean>().validate(bean);
			assertEquals(true, result.hasError());
			assertEquals("{0}の入力は必須です", result.get().getMessage());
		}

		{
			LOG.debug("#requiredTest");
			RequiredTestBean bean = new RequiredTestBean();
			bean.setName("test");

			ValidateErrorResult result = new BeanValidator<RequiredTestBean>().validate(bean);
			assertEquals(false, result.hasError());
		}

	}

	private static class RequiredTestBean {

		@Required
		private String name;

		/**
		 * nameを返す
		 *
		 * @return name
		 *
		 */
		public String getName() {
			return name;
		}

		/**
		 * nameを設定する
		 *
		 * @param name
		 *            name
		 *
		 */
		public void setName(String name) {
			this.name = name;
		}

	}
}
