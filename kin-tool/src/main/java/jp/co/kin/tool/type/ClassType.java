package jp.co.kin.tool.type;

import jp.co.kin.common.type.BaseEnum;

public enum ClassType implements BaseEnum {

	/** クラス */
	CLASS("class"),
	/** インターフェース */
	INTERFACE("interface"),
	/** アノテーション */
	ANNOTATION("@interface"),
	/** 列挙 */
	ENUM("enum");

	private ClassType(String value) {
		this.value = value;
	}

	private String value;

	@Override
	public String getValue() {
		return this.value;
	}

	public static ClassType of(String value) {
		return BaseEnum.of(ClassType.class, value);
	}
}
