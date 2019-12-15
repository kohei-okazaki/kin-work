package jp.co.kin.tool.type;

import jp.co.kin.common.type.BaseEnum;

/**
 * ExecuteType
 * 
 * @since 1.0.0
 *
 */
public enum ExecuteType implements BaseEnum {

	/** entity作成 */
	ENTITY("ENTITY", "\\kin-db\\src\\main\\java\\jp\\co\\kin\\db\\entity"),
	/** DDL作成 */
	DDL("DDL", "\\kin-docs\\detail-design\\sql\\ddl"),
	/** DML作成 */
	DML("DML", "\\kin-docs\\detail-design\\sql\\dml"),
	/** DROP作成 */
	DROP("DROP", "\\kin-docs\\detail-design\\sql\\drop"),
	/** TABLE_DEFINE */
	TABLE_DEFINE("TABLE_DEFINE", "\\kin-docs\\detail-design\\sql\\others"),
	/** DAO */
	DAO("DAO", "\\kin-db\\src\\main\\java\\jp\\co\\kin\\db\\dao");

	/** 値 */
	private String value;
	/** 出力先パス */
	private String outputFilePath;

	private ExecuteType(String value, String outputFilePath) {
		this.value = value;
		this.outputFilePath = outputFilePath;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	public static ExecuteType of(String value) {
		return BaseEnum.of(ExecuteType.class, value);
	}
}
