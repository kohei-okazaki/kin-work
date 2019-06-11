package jp.co.kin.tool.build;

import java.util.List;

import jp.co.kin.common.io.file.property.reader.PropertyReader;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.util.FileUtil.FileSeparator;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.config.ExcelConfig;
import jp.co.kin.tool.config.FileConfig;
import jp.co.kin.tool.config.ToolProperties;
import jp.co.kin.tool.excel.Cell;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.reader.ExcelReader;
import jp.co.kin.tool.type.CellPositionType;
import jp.co.kin.tool.type.ExecuteType;

public abstract class BaseBuilder {

	/** LOG */
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/** 対象テーブルリスト */
	protected List<String> targetTableList;
	/** 基底ディレクトリ */
	protected String baseDir;

	/** ExcelReader */
	protected ExcelReader reader;

	public BaseBuilder() {
		this.init();
	}

	private void init() {

		String resourcePath = this.getClass().getClassLoader().getResource("").getPath()
				+ FileSeparator.SYSTEM.getValue() + "META-INF";
		ToolProperties prop = new PropertyReader().read(resourcePath, "tool.properties", ToolProperties.class);

		this.targetTableList = StringUtil.toStrList(prop.getTargetTable(), StringUtil.COMMA);

		this.baseDir = prop.getBaseDir();

		this.reader = new ExcelReader(getExcelConfig());
	}

	/**
	 * excel設定情報を返す
	 *
	 * @return ExcelConfig
	 */
	protected ExcelConfig getExcelConfig() {
		ExcelConfig conf = new ExcelConfig();
		conf.setFilePath(baseDir + "\\kin-docs\\detail-design\\DB.xlsx");
		conf.setSheetName("TABLE_LIST");
		return conf;
	}

	/**
	 * ファイル設定情報を返す
	 *
	 * @param execType
	 *            実行タイプ
	 * @return FileConfig
	 */
	protected FileConfig getFileConfig(ExecuteType execType) {
		FileConfig conf = new FileConfig();
		switch (execType) {
		case DDL:
			conf.setOutputPath(this.baseDir + "\\kin-resource\\db\\ddl");
			break;
		case ENTITY:
			conf.setOutputPath(this.baseDir + "\\kin-db\\src\\main\\java\\jp\\co\\kin\\db\\entity");
			break;
		case DROP:
			conf.setOutputPath(this.baseDir + "\\kin-resource\\db\\drop");
			break;
		case DML:
			conf.setOutputPath(this.baseDir + "\\kin-resource\\db\\dml");
			break;
		case TABLE_DEFINE:
			conf.setOutputPath(this.baseDir + "\\kin-resource\\db\\others");
			break;
		case DAO:
			conf.setOutputPath(this.baseDir + "\\kin-db\\src\\main\\java\\jp\\co\\kin\\db\\dao");
			break;
		default:
			LOG.warn("SQL生成の指定が間違っています execType:" + execType.getValue());
			break;
		}
		return conf;
	}

	/**
	 * 対象のテーブルかどうか判定
	 *
	 * @param row
	 *            excelの行情報
	 * @param tableName
	 *            テーブル名
	 * @return 判定結果
	 */
	protected boolean isTargetTable(Row row, String tableName) {
		Cell cell = row.getCell(CellPositionType.PHYSICAL_NAME);
		return tableName.equals(cell.getValue());
	}
}
