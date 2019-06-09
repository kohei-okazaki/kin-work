package jp.co.kin.tool.build;

import java.util.List;
import java.util.Properties;

import jp.co.kin.common.io.file.property.reader.PropertyReader;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.FileUtil.FileSeparator;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.reader.ExcelReader;

public abstract class BaseBuilder {

	/** LOG */
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/** 対象テーブルリスト */
	protected List<String> targetTableList;
	/** 基底ディレクトリ */
	protected String baseDir;

	/** ExcelReader */
	protected ExcelReader reader;

	private void init() {

		String resourcePath = this.getClass().getClassLoader().getResource("").getPath()
				+ FileSeparator.SYSTEM.getValue() + "META-INF";
		Properties prop = new PropertyReader().read(resourcePath, "tool.properties");

		String targetTable = prop.getProperty("targetTable");
		if (BeanUtil.notNull(targetTable)) {
			this.targetTableList = StringUtil.toStrList(targetTable, StringUtil.COMMA);
		}

		this.baseDir = prop.getProperty("baseDir");

		// this.reader = new ExcelReader(getExcelConfig());
	}
}
