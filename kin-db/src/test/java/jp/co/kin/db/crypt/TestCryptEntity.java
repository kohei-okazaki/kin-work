package jp.co.kin.db.crypt;

import jp.co.kin.common.crypt.annotation.Crypt;
import jp.co.kin.db.entity.BaseEntity;

public class TestCryptEntity extends BaseEntity {

	private String name;
	@Crypt
	private String cryptName;

	/**
	 * nameを返す
	 *
	 * @return name
	 *
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定する
	 *
	 * @param name
	 *            name
	 *
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * cryptNameを返す
	 *
	 * @return cryptName
	 *
	 */
	public String getCryptName() {
		return cryptName;
	}

	/**
	 * cryptNameを設定する
	 *
	 * @param cryptName
	 *            cryptName
	 *
	 */
	public void setCryptName(String cryptName) {
		this.cryptName = cryptName;
	}

}
