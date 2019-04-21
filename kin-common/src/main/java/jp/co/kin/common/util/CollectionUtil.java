package jp.co.kin.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * CollectionUtil
 *
 */
public class CollectionUtil {

	private CollectionUtil() {
	}

	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

	public static <T> T getFirst(List<T> list) {
		if (isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	public static <T> T getLast(List<T> list) {
		if (isEmpty(list)) {
			return null;
		}
		return list.get(list.size() - 1);
	}

	public static boolean exists(List<?> list) {
		return !isEmpty(list);
	}

	public static <T> List<T> getEmptyList(Class<T> clazz) {
		return new ArrayList<>();
	}

	public static <T> List<T> toList(T[] array) {
		return Stream.of(array).collect(Collectors.toList());
	}

	public static <T> List<T> copyList(List<T> src) {
		return src.stream().collect(Collectors.toList());
	}
}
