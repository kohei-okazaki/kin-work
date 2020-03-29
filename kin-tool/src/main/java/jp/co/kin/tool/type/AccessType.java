package jp.co.kin.tool.type;

import jp.co.kin.common.type.BaseEnum;

/**
 * AccessType
 *
 * @since 1.0.0
 *
 */
public enum AccessType implements BaseEnum {

    /** public */
    PUBLIC("public"),
    /** protected */
    PROTECTED("protected"),
    /** デフォルト */
    DEFAULT(""),
    /** private */
    PRIVATE("private");

    /** 値 */
    private String value;

    private AccessType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static AccessType of(String value) {
        return BaseEnum.of(AccessType.class, value);
    }
}
