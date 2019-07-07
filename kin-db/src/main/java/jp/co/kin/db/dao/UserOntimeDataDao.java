package jp.co.kin.db.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import jp.co.kin.db.config.DaoRepository;
import jp.co.kin.db.entity.UserOntimeData;

@Dao
@DaoRepository
public interface UserOntimeDataDao extends BaseDao {

	@Delete
	public int delete(UserOntimeData entity);

	@Update
	public int update(UserOntimeData entity);

	@Insert
	public int insert(UserOntimeData entity);

	@Select
	public UserOntimeData selectById(String loginId);

	@Select
	public int selectCountById(String loginId);

}
