package jp.co.kin.common.type;

import java.time.ZoneId;

public enum ZoneIdType implements BaseEnum {

	/** 東京 */
	TOKYO("Asia/Tokyo");

	private ZoneIdType(String value) {
		this.value = value;
	}

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
