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

/**
 * BaseBuilder
 *
 * @since 1.0.0
 */
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
		ToolProperties prop = new PropertyReader().read(resourcePath, "tool.properties",
				ToolProperties.class);

		this.targetTableList = StringUtil.toStrList(prop.getTargetTable(), StringUtil.COMMA);

		this.baseDir = prop.getBaseDir();

		this.reader = new ExcelReader(getExcelConfig());
	}

	protected ExcelConfig getExcelConfig() {
		ExcelConfig conf = new ExcelConfig();
		conf.setFilePath(baseDir + "\\kin-docs\\detail-design\\90_DB設計.xlsx");
		conf.setSheetName("TABLE_LIST");
		return conf;
	}

	protected FileConfig getFileConfig(ExecuteType execType) {
		FileConfig conf = new FileConfig();
		conf.setOutputPath(this.baseDir + execType.getOutputFilePath());
		return conf;
	}

	protected boolean isTargetTable(Row row, String tableName) {
		Cell cell = row.getCell(CellPositionType.PHYSICAL_NAME);
		return tableName.equals(cell.getValue());
	}
}
