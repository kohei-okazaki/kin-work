package jp.co.kin.db.listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

import jp.co.kin.common.bean.BeanFactory;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.LocalDateTimeUtil;
import jp.co.kin.db.crypt.EntityCrypter;
import jp.co.kin.db.crypt.EntityCrypterImpl;
import jp.co.kin.db.entity.BaseEntity;

/**
 * 以下のDataBase操作処理のリスナークラス
 * <ul>
 * <li>DELETE</li>
 * <li>INSERT</li>
 * <li>UPDATE</li>
 * </ul>
 *
 * @param <T>
 *            Entity継承クラス
 */
public class DaoListener<T extends BaseEntity> implements EntityListener<T> {

	private static final Logger LOG = LoggerFactory.getLogger(DaoListener.class);

	private EntityCrypter entityCrypter = BeanFactory.getBean(EntityCrypterImpl.class);

	@Override
	public void preDelete(T entity, PreDeleteContext<T> context) {
		EntityListener.super.preDelete(entity, context);
	}

	@Override
	public void preInsert(T entity, PreInsertContext<T> context) {
		try {
			for (Method m : BeanUtil.getMethodList(entity.getClass())) {
				if ("setRegDate".equals(m.getName()) || "setUpdateDate".equals(m.getName())) {
					// 登録日時/更新日時の設定
					m.invoke(entity, LocalDateTimeUtil.getSysDate());
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOG.error("setterの実行に失敗しました", e);
		}

		// 暗号化
		entityCrypter.encrypt(entity);

		EntityListener.super.preInsert(entity, context);
	}

	@Override
	public void preUpdate(T entity, PreUpdateContext<T> context) {
		try {
			for (Method m : BeanUtil.getMethodList(entity.getClass())) {
				if ("setUpdateDate".equals(m.getName())) {
					// 更新日時の設定
					m.invoke(entity, LocalDateTimeUtil.getSysDate());
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOG.error("setterの実行に失敗しました", e);
		}

		// 暗号化
		entityCrypter.encrypt(entity);

		// 暗号化
		EntityListener.super.preUpdate(entity, context);
	}

	@Override
	public void postDelete(T entity, PostDeleteContext<T> context) {
		EntityListener.super.postDelete(entity, context);
	}

	@Override
	public void postInsert(T entity, PostInsertContext<T> context) {
		EntityListener.super.postInsert(entity, context);
	}

	@Override
	public void postUpdate(T entity, PostUpdateContext<T> context) {
		EntityListener.super.postUpdate(entity, context);
	}

}
