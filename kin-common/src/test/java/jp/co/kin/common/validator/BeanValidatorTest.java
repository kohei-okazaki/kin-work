package jp.co.kin.common.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.test.BaseCommonTest;
import jp.co.kin.common.type.RegixType;
import jp.co.kin.common.validator.annotation.Flag;
import jp.co.kin.common.validator.annotation.Max;
import jp.co.kin.common.validator.annotation.Min;
import jp.co.kin.common.validator.annotation.Pattern;
import jp.co.kin.common.validator.annotation.Required;

/**
 * {@link BeanValidator} のjUnit
 */
public class BeanValidatorTest extends BaseCommonTest {

	/** LOG */
	private final static Logger LOG = LoggerFactory.getLogger(BeanValidatorTest.class);

	/**
	 * 妥当性チェック(必須チェック)のケース
	 */
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
			bean.setValue("test");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(false, result.hasError());
		}
	}

	/**
	 * 妥当性チェック(最小桁数チェック)のケース
	 */
	@Test
	public void minTest() {

		// =を含むケース
		{
			LOG.debug("#minTest");
			MinEqualsTestBean bean = new MinEqualsTestBean();
			bean.setValue("123");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(false, result.hasError());
		}
		{
			LOG.debug("#minTest");
			MinEqualsTestBean bean = new MinEqualsTestBean();
			bean.setValue("12");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(true, result.hasError());
		}

		// =を含まないケース
		{
			LOG.debug("#minTest");
			MinTestBean bean = new MinTestBean();
			bean.setValue("1234");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(false, result.hasError());
		}
		{
			LOG.debug("#minTest");
			MinTestBean bean = new MinTestBean();
			bean.setValue("123");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(true, result.hasError());
		}
		{
			LOG.debug("#minTest");
			MinTestBean bean = new MinTestBean();
			bean.setValue("12");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(true, result.hasError());
		}
	}

	/**
	 * 妥当性チェック(最大桁数チェック)のケース
	 */
	@Test
	public void maxTest() {

		// =を含むケース
		{
			LOG.debug("#maxTest");
			MaxEqualsTestBean bean = new MaxEqualsTestBean();
			bean.setValue("123");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(false, result.hasError());
		}
		{
			LOG.debug("#maxTest");
			MaxEqualsTestBean bean = new MaxEqualsTestBean();
			bean.setValue("1234");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(true, result.hasError());
		}

		// =を含まないケース
		{
			LOG.debug("#maxTest");
			MaxTestBean bean = new MaxTestBean();
			bean.setValue("1234");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(true, result.hasError());
		}
		{
			LOG.debug("#maxTest");
			MaxTestBean bean = new MaxTestBean();
			bean.setValue("123");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(true, result.hasError());
		}
		{
			LOG.debug("#maxTest");
			MaxTestBean bean = new MaxTestBean();
			bean.setValue("12");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(false, result.hasError());
		}
	}

	/**
	 * 妥当性チェック(属性チェック)のケース
	 */
	@Test
	public void patternTest() {
		{
			// 半角数字
			{
				LOG.debug("#patternTest");
				HalfNumberPatternTestBean bean = new HalfNumberPatternTestBean();
				bean.setValue("1");

				ValidateErrorResult result = new BeanValidator<>().validate(bean);
				assertEquals(false, result.hasError());
			}
			{
				LOG.debug("#patternTest");
				HalfNumberPatternTestBean bean = new HalfNumberPatternTestBean();
				bean.setValue("a");

				ValidateErrorResult result = new BeanValidator<>().validate(bean);
				assertEquals(true, result.hasError());
			}
			{
				LOG.debug("#patternTest");
				HalfNumberPatternTestBean bean = new HalfNumberPatternTestBean();
				bean.setValue("1a");

				ValidateErrorResult result = new BeanValidator<>().validate(bean);
				assertEquals(true, result.hasError());
			}
		}

		{
			// 半角英数字
			{
				LOG.debug("#patternTest");
				HalfCharPatternTestBean bean = new HalfCharPatternTestBean();
				bean.setValue("1");

				ValidateErrorResult result = new BeanValidator<>().validate(bean);
				assertEquals(false, result.hasError());
			}
			{
				LOG.debug("#patternTest");
				HalfCharPatternTestBean bean = new HalfCharPatternTestBean();
				bean.setValue("a");

				ValidateErrorResult result = new BeanValidator<>().validate(bean);
				assertEquals(false, result.hasError());
			}
			{
				LOG.debug("#patternTest");
				HalfCharPatternTestBean bean = new HalfCharPatternTestBean();
				bean.setValue("1a");

				ValidateErrorResult result = new BeanValidator<>().validate(bean);
				assertEquals(false, result.hasError());
			}
			{
				LOG.debug("#patternTest");
				HalfCharPatternTestBean bean = new HalfCharPatternTestBean();
				bean.setValue("あ");

				ValidateErrorResult result = new BeanValidator<>().validate(bean);
				assertEquals(true, result.hasError());
			}
		}
	}

	@Test
	public void flagTest() {
		{
			LOG.debug("#flagTest");
			FlagTestBean bean = new FlagTestBean();
			bean.setValue("0");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(false, result.hasError());
		}
		{
			LOG.debug("#flagTest");
			FlagTestBean bean = new FlagTestBean();
			bean.setValue("1");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(false, result.hasError());
		}
		{
			LOG.debug("#flagTest");
			FlagTestBean bean = new FlagTestBean();

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(false, result.hasError());
		}
		{
			LOG.debug("#flagTest");
			FlagTestBean bean = new FlagTestBean();
			bean.setValue("2");

			ValidateErrorResult result = new BeanValidator<>().validate(bean);
			assertEquals(true, result.hasError());
		}
	}

	private static class RequiredTestBean {

		@Required
		private String value;

		/**
		 * valueを返す
		 *
		 * @return value
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 * valueを設定する
		 *
		 * @param value
		 *            value
		 *
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}

	private static class MinEqualsTestBean {

		@Min(size = 3)
		private String value;

		/**
		 * valueを返す
		 *
		 * @return value
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 * valueを設定する
		 *
		 * @param value
		 *            value
		 *
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}

	private static class MinTestBean {

		@Min(size = 3, isEqual = false)
		private String value;

		/**
		 * valueを返す
		 *
		 * @return value
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 * valueを設定する
		 *
		 * @param value
		 *            value
		 *
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}

	private static class MaxEqualsTestBean {

		@Max(size = 3)
		private String value;

		/**
		 * valueを返す
		 *
		 * @return value
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 * valueを設定する
		 *
		 * @param value
		 *            value
		 *
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}

	private static class MaxTestBean {

		@Max(size = 3, isEqual = false)
		private String value;

		/**
		 * valueを返す
		 *
		 * @return value
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 * valueを設定する
		 *
		 * @param value
		 *            value
		 *
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}

	private static class HalfNumberPatternTestBean {

		@Pattern(regixPattern = RegixType.HALF_NUMBER, message = "値は半角数字です")
		private String value;

		/**
		 * valueを返す
		 *
		 * @return value
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 * valueを設定する
		 *
		 * @param value
		 *            value
		 *
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}

	private static class HalfCharPatternTestBean {

		@Pattern(regixPattern = RegixType.HALF_CHAR, message = "値は半角英数字です")
		private String value;

		/**
		 * valueを返す
		 *
		 * @return value
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 * valueを設定する
		 *
		 * @param value
		 *            value
		 *
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}

	private static class FlagTestBean {

		@Flag
		private String value;

		/**
		 * valueを返す
		 *
		 * @return value
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 * valueを設定する
		 *
		 * @param value
		 *            value
		 *
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}
}
