package jp.co.kin.tool.type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jp.co.kin.common.type.BaseEnum;

/**
 * ColumnType
 *
 * @since 1.0.0
 *
 */
public enum ColumnType implements BaseEnum {

    /** VARCHAR */
    VARCHAR("VARCHAR", String.class),
    /** DATE */
    DATE("DATE", LocalDate.class),
    /** TIMESTAMP */
    TIMESTAMP("TIMESTAMP", LocalDateTime.class),
    /** DOUBLE */
    DECIMAL("DECIMAL", BigDecimal.class),
    /** INT */
    INT("INT", BigDecimal.class);

    /** 値 */
    private String value;
    /** クラス型 */
    private Class<?> classType;

    private ColumnType(String value, Class<?> classType) {
        this.value = value;
        this.classType = classType;
    }

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
