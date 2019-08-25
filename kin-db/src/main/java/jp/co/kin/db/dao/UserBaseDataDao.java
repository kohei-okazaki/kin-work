package jp.co.kin.db.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import jp.co.kin.db.config.DaoRepository;
import jp.co.kin.db.entity.UserBaseData;

/**
 * ユーザ基本情報 Dao
 *
 */
@Dao
@DaoRepository
public interface UserBaseDataDao extends BaseDao {

	@Delete
	public int delete(UserBaseData entity);

	@Update
	public int update(UserBaseData entity);

	@Insert
	public int insert(UserBaseData entity);

	@Select
	public UserBaseData selectById(String userId);

}
