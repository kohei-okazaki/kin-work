package jp.co.kin.common.log;

public class LoggerFactory {

	private LoggerFactory() {
	}

	/**
	 * <code>Logger</code>を返す
	 *
	 * @param clazz
	 *            クラス型
	 * @return <code>Logger</code>
	 */
	public static Logger getLogger(Class<?> clazz) {
		return new Logger(org.slf4j.LoggerFactory.getLogger(clazz));
	}

}
