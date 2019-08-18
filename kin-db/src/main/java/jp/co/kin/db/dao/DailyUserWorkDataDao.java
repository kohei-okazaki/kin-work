package jp.co.kin.db.dao;

import java.time.LocalDate;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import jp.co.kin.db.config.DaoRepository;
import jp.co.kin.db.entity.DailyUserWorkData;

@Dao
@DaoRepository
public interface DailyUserWorkDataDao extends BaseDao {

	@Delete
	public int delete(DailyUserWorkData entity);

	@Update
	public int update(DailyUserWorkData entity);

	@Insert
	public int insert(DailyUserWorkData entity);

	@Select
	public List<DailyUserWorkData> selectByWorkDate(LocalDate workStartDate, LocalDate workEndDate,
			String userId);

}
