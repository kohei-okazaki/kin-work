package jp.co.kin.tool.source;

import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.type.AccessType;

/**
 * Getter
 *
 * @since 1.0.0
 */
public class Getter extends Method {

    /** 接頭語 */
    private static final String PREFIX = "get";

    /**
     * コンストラクタ
     *
     * @param field
     *     Field
     */
    public Getter(Field field) {
        this(field, AccessType.PUBLIC);
    }

    /**
     * コンストラクタ
     *
     * @param field
     *     Field
     * @param accessType
     *     アクセスタイプ
     */
    public Getter(Field field, AccessType accessType) {
        super(field, accessType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        final String TAB = "	";

        StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
        body.add(TAB + accessType.getValue() + " " + field.getClassType().getSimpleName()
                + " "
                + getMethodName() + "() {");
        body.add(TAB + TAB + "return " + field.getName() + ";");
        body.add(TAB + "}");

        return body.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMethodName() {
        return PREFIX + StringUtils.capitalize(field.getName());
    }
}
