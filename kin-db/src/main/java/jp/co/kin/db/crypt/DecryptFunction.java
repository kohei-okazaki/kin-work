package jp.co.kin.db.crypt;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.kin.common.util.CollectionUtil;
import jp.co.kin.db.entity.BaseEntity;

@Component
public class DecryptFunction<T extends BaseEntity> implements Function<Stream<T>, T> {

	@Autowired
	private EntityCrypter entityCrypter;

	@Override
	public T apply(Stream<T> t) {

		List<T> list = t.map(e -> {
			entityCrypter.decrypt(e);
			return e;
		}).collect(Collectors.toList());

		return CollectionUtil.isEmpty(list) ? null : list.get(0);
	}

}
