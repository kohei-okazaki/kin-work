package jp.co.kin.db.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.Update;

import jp.co.kin.db.config.DaoRepository;
import jp.co.kin.db.crypt.DecryptFunction;
import jp.co.kin.db.entity.LoginUserData;

/**
 * ログインユーザ情報 Dao
 *
 */
@Dao
@DaoRepository
public interface LoginUserDataDao extends BaseDao {

	@Delete
	public int delete(LoginUserData entity);

	@Update
	public int update(LoginUserData entity);

	@Insert
	public int insert(LoginUserData entity);

	@Select(strategy = SelectType.STREAM)
	public LoginUserData selectById(String loginId, DecryptFunction<LoginUserData> function);

	@Select
	public int selectCountById(String loginId);

	@Update(sqlFile = true)
	public int updateFailCount(LoginUserData entity);

	@Update(sqlFile = true)
	public int updateAccountLock(LoginUserData entity);

}
