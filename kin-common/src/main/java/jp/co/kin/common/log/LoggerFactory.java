package jp.co.kin.common.log;

/**
 * LoggerのFactory <code>org.slf4j.LoggerFactory</code>のラッパークラス
 *
 * @since 1.0.0
 */
public class LoggerFactory {

    private LoggerFactory() {
    }

    /**
     * <code>Logger</code>を返す
     *
     * @param clazz
     *     クラス型
     * @return <code>Logger</code>
     */
    public static Logger getLogger(Class<?> clazz) {
        return new Logger(org.slf4j.LoggerFactory.getLogger(clazz));
    }

}
