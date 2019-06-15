package jp.co.kin.tool.type;

import jp.co.kin.common.type.BaseEnum;

public enum ExecuteType implements BaseEnum {

	/** entity作成 */
	ENTITY("ENTITY"),
	/** DDL作成 */
	DDL("DDL"),
	/** DML作成 */
	DML("DML"),
	/** DROP作成 */
	DROP("DROP"),
	/** TABLE_DEFINE */
	TABLE_DEFINE("TABLE_DEFINE"),
	/** DAO */
	DAO("DAO");

	/** 値 */
	private String value;

	private ExecuteType(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static ExecuteType of(String value) {
		return BaseEnum.of(ExecuteType.class, value);
	}
}
