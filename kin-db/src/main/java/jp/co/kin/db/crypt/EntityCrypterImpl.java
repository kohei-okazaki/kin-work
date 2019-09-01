package jp.co.kin.db.crypt;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jp.co.kin.common.crypt.Crypter;
import jp.co.kin.common.crypt.annotation.Crypt;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.BeanUtil.AccessorType;
import jp.co.kin.db.entity.BaseEntity;

@Component
public class EntityCrypterImpl implements EntityCrypter {

	private static final Logger LOG = LoggerFactory.getLogger(EntityCrypterImpl.class);

	@Autowired
	@Qualifier("aesCrypter")
	private Crypter crypter;

	@Override
	public void encrypt(BaseEntity entity) {

		try {

			for (Field field : entity.getClass().getDeclaredFields()) {
				if (!field.isAnnotationPresent(Crypt.class)) {
					continue;
				}

				// 値を取得
				String value = (String) BeanUtil
						.getAccessor(field.getName(), entity.getClass(), AccessorType.GETTER).invoke(entity);

				// 暗号化
				value = crypter.encrypt(value);

				// 値を設定
				BeanUtil.getAccessor(field.getName(), entity.getClass(), AccessorType.SETTER).invoke(entity,
						value);
			}

		} catch (Exception e) {
			LOG.error("暗号化に失敗しました", e);
		}

	}

	@Override
	public void decrypt(BaseEntity entity) {

		try {
			for (Field field : entity.getClass().getDeclaredFields()) {
				if (!field.isAnnotationPresent(Crypt.class)) {
					continue;
				}

				// 値を取得
				String value = (String) BeanUtil
						.getAccessor(field.getName(), entity.getClass(), AccessorType.GETTER).invoke(entity);

				// 復号化
				value = crypter.decrypt(value);

				// 値を設定
				BeanUtil.getAccessor(field.getName(), entity.getClass(), AccessorType.SETTER).invoke(entity,
						value);
			}
		} catch (Exception e) {
			LOG.error("復号化に失敗しました", e);
		}

	}

}
