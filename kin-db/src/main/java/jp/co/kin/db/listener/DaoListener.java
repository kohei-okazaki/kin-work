package jp.co.kin.db.listener;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

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

	@Override
	public void preDelete(T entity, PreDeleteContext<T> context) {
		System.out.println("#preDelete");
		EntityListener.super.preDelete(entity, context);
	}

	@Override
	public void preInsert(T entity, PreInsertContext<T> context) {
		System.out.println("#preInsert");
		EntityListener.super.preInsert(entity, context);
	}

	@Override
	public void preUpdate(T entity, PreUpdateContext<T> context) {
		System.out.println("#preUpdate");
		EntityListener.super.preUpdate(entity, context);
	}

	@Override
	public void postDelete(T entity, PostDeleteContext<T> context) {
		System.out.println("#postDelete");
		EntityListener.super.postDelete(entity, context);
	}

	@Override
	public void postInsert(T entity, PostInsertContext<T> context) {
		System.out.println("#postInsert");
		EntityListener.super.postInsert(entity, context);
	}

	@Override
	public void postUpdate(T entity, PostUpdateContext<T> context) {
		System.out.println("#postUpdate");
		EntityListener.super.postUpdate(entity, context);
	}

}
