package jp.co.kin.db.crypt;

import jp.co.kin.db.entity.BaseEntity;

/**
 * Entity暗号化インターフェース
 *
 * @since 1.0.0
 */
public interface EntityCrypter {

    /**
     * 指定されたEntityクラスの暗号化を行う
     *
     * @param entity
     *     基底Entityクラス
     */
    void encrypt(BaseEntity entity);

    /**
     * 指定されたEntityクラスの復号化を行う
     *
     * @param entity
     *     基底Entityクラス
     */
    void decrypt(BaseEntity entity);

}
