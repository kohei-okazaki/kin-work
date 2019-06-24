package jp.co.kin.db.crypt;

import jp.co.kin.db.entity.BaseEntity;

public interface EntityCrypter {

	void encrypt(BaseEntity entity);

	void decrypt(BaseEntity entity);

}
