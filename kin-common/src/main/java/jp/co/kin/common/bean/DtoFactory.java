package jp.co.kin.common.bean;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.util.BeanUtil;

public class DtoFactory {

	private static final Logger LOG = LoggerFactory.getLogger(DtoFactory.class);

	private DtoFactory() {
	}

	/**
	 * DTOを返す
	 *
	 * @param <T>
	 *            DTO具象クラス
	 * @param dtoClass
	 *            DTOクラス
	 * @param bean
	 *            コピー元データ
	 * @return DTO
	 */
	public static <T extends BaseDto> T getDto(Class<T> dtoClass, Object bean) {

		if (BeanUtil.isNull(bean)) {
			return null;
		}

		try {
			T t = dtoClass.getDeclaredConstructor().newInstance();
			BeanUtil.copy(bean, t);
			return t;
		} catch (Exception e) {
			LOG.error("DTOの生成に失敗しました", e);
			return null;
		}
	}

}
