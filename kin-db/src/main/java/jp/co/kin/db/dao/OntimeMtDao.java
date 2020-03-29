package jp.co.kin.db.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import jp.co.kin.db.config.DaoRepository;
import jp.co.kin.db.entity.OntimeMt;

/**
 * 定時情報マスタ Dao
 *
 */
@Dao
@DaoRepository
public interface OntimeMtDao extends BaseDao {

    @Delete
    public int delete(OntimeMt entity);

    @Update
    public int update(OntimeMt entity);

    @Insert
    public int insert(OntimeMt entity);

    @Select
    public OntimeMt selectById(String companyCode);

    @Select
    public Integer selectCountById(String companyCode);

    @Update(sqlFile = true)
    public int updateEntity(OntimeMt entity);

    @Select
    public List<OntimeMt> select();

}
