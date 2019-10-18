package jp.co.kin.common.type;

import java.time.ZoneId;

/**
 * java.time.ZoneIdの列挙
 * 
 * @since 1.0.0
 *
 */
public enum ZoneIdType implements BaseEnum {

	/** 東京 */
	TOKYO("Asia/Tokyo");

	private ZoneIdType(String value) {
		this.value = value;
	}

	/** 値 */
	private String value;

	@Override
	public String getValue() {
		return this.value;
	}

	public ZoneId getZoneId() {
		return ZoneId.of(this.value);
	}

	public static ZoneIdType of(String value) {
		return BaseEnum.of(ZoneIdType.class, value);
	}
}
