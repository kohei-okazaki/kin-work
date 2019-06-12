package jp.co.kin.db.listener;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 以下のDataBase操作処理のリスナークラス
 * <ul>
 * <li>DELETE</li>
 * <li>INSERT</li>
 * <li>UPDATE</li>
 * </ul>
 */
public class DaoListener<BaseEntity> implements EntityListener<BaseEntity> {

	@Override
	public void preDelete(BaseEntity entity, PreDeleteContext<BaseEntity> context) {
		System.out.println("#preDelete");
		EntityListener.super.preDelete(entity, context);
	}

	@Override
	public void preInsert(BaseEntity entity, PreInsertContext<BaseEntity> context) {
		System.out.println("#preInsert");
		EntityListener.super.preInsert(entity, context);
	}

	@Override
	public void preUpdate(BaseEntity entity, PreUpdateContext<BaseEntity> context) {
		System.out.println("#preUpdate");
		EntityListener.super.preUpdate(entity, context);
	}

	@Override
	public void postDelete(BaseEntity entity, PostDeleteContext<BaseEntity> context) {
		System.out.println("#postDelete");
		EntityListener.super.postDelete(entity, context);
	}

	@Override
	public void postInsert(BaseEntity entity, PostInsertContext<BaseEntity> context) {
		System.out.println("#postInsert");
		EntityListener.super.postInsert(entity, context);
	}

	@Override
	public void postUpdate(BaseEntity entity, PostUpdateContext<BaseEntity> context) {
		System.out.println("#postUpdate");
		EntityListener.super.postUpdate(entity, context);
	}

}
