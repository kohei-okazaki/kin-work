package jp.co.kin.db.config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Dao設定情報クラス
 */
@Configuration
public class DaoConfig implements Config {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private Dialect dialect;
	@Autowired
	private SqlFileRepository sqlFileRepository;

	public DaoConfig() {
	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Dialect getDialect() {
		return dialect;
	}

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	@Override
	public SqlFileRepository getSqlFileRepository() {
		return sqlFileRepository;
	}

	public void setSqlFileRepository(SqlFileRepository sqlFileRepository) {
		this.sqlFileRepository = sqlFileRepository;
	}

}
