package jp.co.kin.tool.type;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.kin.common.type.BaseEnum;

public enum ColumnType implements BaseEnum {

	/** VARCHAR */
	VARCHAR("VARCHAR", String.class),
	/** DATE */
	DATE("DATE", Date.class),
	/** TIMESTAMP */
	TIMESTAMP("TIMESTAMP", Date.class),
	/** DOUBLE */
	DECIMAL("DECIMAL", BigDecimal.class),
	/** INT */
	INT("INT", BigDecimal.class);

	private ColumnType(String value, Class<?> classType) {
		this.value = value;
		this.classType = classType;
	}

	/** 値 */
	private String value;
	/** クラス型 */
	private Class<?> classType;

	@Override
	public String getValue() {
		return value;
	}

	public Class<?> getClassType() {
		return this.classType;
	}

	public static ColumnType of(String value) {
		return BaseEnum.of(ColumnType.class, value);
	}
}
