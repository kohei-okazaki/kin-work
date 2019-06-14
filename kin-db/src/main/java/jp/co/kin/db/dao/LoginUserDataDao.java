package jp.co.kin.db.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;

import jp.co.kin.db.config.DaoRepository;
import jp.co.kin.db.entity.LoginUserData;

@Dao
@DaoRepository
public interface LoginUserDataDao extends BaseDao {

	@Delete
	public int delete(LoginUserData entity);

	@Update
	public int update(LoginUserData entity);

	@Insert
	public int insert(LoginUserData entity);

}
