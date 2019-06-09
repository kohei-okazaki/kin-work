package jp.co.kin.common.context;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import jp.co.kin.common.util.BeanUtil;

public class BeanContextLoader {

	/** ApplicationContext */
	private static ApplicationContext context;

	private BeanContextLoader() {
	}

	/**
	 * Beanを取得
	 *
	 * @param clazz
	 *            Beanの実装クラス
	 * @return Bean
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getContext().getBean(clazz);
	}

	/**
	 * ApplicationContextを返す
	 *
	 * @return ApplicationContext
	 */
	private static ApplicationContext getContext() {

		if (BeanUtil.notNull(context)) {
			return context;
		}
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		context = RequestContextUtils.findWebApplicationContext(sra.getRequest());
		return context;
	}

	/**
	 * ApplicationContextを設定する
	 *
	 * @param context
	 *            ApplicationContext
	 */
	public static void setContext(ApplicationContext context) {
		BeanContextLoader.context = context;
	}
}
