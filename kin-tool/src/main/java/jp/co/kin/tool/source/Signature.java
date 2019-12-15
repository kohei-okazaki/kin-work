package jp.co.kin.tool.source;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

import jp.co.kin.common.util.StringUtil;

/**
 * Signature
 *
 * @since 1.0.0
 */
public class Signature {

	private Map<Class<?>, String> argsMap = new LinkedHashMap<>();

	public void addArgs(Class<?> clazz, String name) {
		argsMap.put(clazz, name);
	}

	@Override
	public String toString() {

		if (argsMap.isEmpty()) {
			return "";
		}

		StringJoiner body = new StringJoiner(StringUtil.SPACE);
		argsMap.entrySet().forEach(e -> body.add(e.getKey().getSimpleName() + " " + e.getValue()));

		return body.toString();
	}
}
