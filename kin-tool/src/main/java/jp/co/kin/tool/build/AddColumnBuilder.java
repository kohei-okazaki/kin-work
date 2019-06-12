package jp.co.kin.tool.build;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import jp.co.kin.common.type.CommonFlag;
import jp.co.kin.common.type.DateFormatType;
import jp.co.kin.common.util.DateUtil;
import jp.co.kin.common.util.FileUtil.FileExtension;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.build.annotation.Build;
import jp.co.kin.tool.config.FileConfig;
import jp.co.kin.tool.excel.Excel;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.factory.FileFactory;
import jp.co.kin.tool.type.CellPositionType;
import jp.co.kin.tool.type.ExecuteType;

/**
 * カラム追加のDDLを作成するビルダー<br>
 * <ul>
 * <li>テーブル名:HOGE</li>
 * <li>カラム名:PIYO</li>
 * <li>カラム定義:FUGA</li>
 * </ul>
 * の場合、<br>
 * <code>ALTER TABLE HOGE ADD PIYO FUGA;</code><br>
 * のDDLを作成
 */
public class AddColumnBuilder extends BaseBuilder {

	@Build
	public void execute() {

		Excel excel = super.reader.read();
		excel.activeSheet("TABLE_LIST");

		List<Row> targetRowList = getTargetRowList(excel.getRowList());

		StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);

		targetRowList.stream().forEach(e -> {
			String ddlPrefix = "ALTER TABLE ";
			String ddlSuffix = ";";
			String tableName = e.getCell(CellPositionType.PHYSICAL_NAME).getValue();
			String columnName = e.getCell(CellPositionType.COLUMN_NAME).getValue();
			String columnType = getColumnType(e);
			String ddl = ddlPrefix + tableName + " ADD " + columnName + " " + columnType + ddlSuffix;
			body.add(ddl);
		});

		FileConfig fileConf = getFileConfig(ExecuteType.DDL);
		fileConf.setFileName(DateUtil.toString(DateUtil.getSysDate(), DateFormatType.YYYYMMDD_HHMMSS_NOSEP)
				+ FileExtension.SQL.getValue());
		fileConf.setData(body.toString());
		FileFactory.create(fileConf);
	}

	private List<Row> getTargetRowList(List<Row> rowList) {
		return rowList.stream()
				.filter(e -> CommonFlag.TRUE.is(e.getCell(CellPositionType.ADD_FLG).getValue()))
				.collect(Collectors.toList());
	}

	private String getColumnType(Row row) {
		String columnType = row.getCell(CellPositionType.COLUMN_TYPE).getValue();
		String size = getSize(row);
		return columnType + size;
	}

	private String getSize(Row row) {
		String size = row.getCell(CellPositionType.COLUMN_SIZE).getValue();
		return StringUtil.isBrank(size) ? StringUtil.EMPTY : "(" + size + ")";
	}

}