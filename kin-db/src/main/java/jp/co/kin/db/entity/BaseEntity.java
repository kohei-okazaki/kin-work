package jp.co.kin.db.entity;

import org.seasar.doma.Entity;

import jp.co.kin.db.listener.DaoListener;

/**
 * Entityの基底クラス<br>
 * 全Entityクラスはこのクラスを継承すること
 * 
 * @since 1.0.0
 */
@Entity(listener = DaoListener.class)
public abstract class BaseEntity {

}
