package jp.co.kin.tool.build;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import jp.co.kin.common.type.CommonFlag;
import jp.co.kin.common.type.LineFeedType;
import jp.co.kin.common.util.FileUtil.FileExtension;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.build.annotation.Build;
import jp.co.kin.tool.config.FileConfig;
import jp.co.kin.tool.db.Column;
import jp.co.kin.tool.db.Table;
import jp.co.kin.tool.excel.Excel;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.factory.FileFactory;
import jp.co.kin.tool.type.CellPositionType;
import jp.co.kin.tool.type.ExecuteType;

public class CreateTableBuilder extends BaseBuilder {

	@Build
	public void execute() {

		Excel excel = super.reader.read();
		excel.activeSheet("TABLE_LIST");

		for (String tableName : this.targetTableList) {
			Table table = toTable(excel.getRowList(), tableName);
			StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
			body.add(getTableComment(table.getLogicalName()));
			body.add("CREATE TABLE " + tableName + " (");
			StringJoiner columnData = new StringJoiner(StringUtil.COMMA + LineFeedType.CRLF.getValue());
			table.getColumnList().stream().forEach(e -> {
				String comment = e.getComment();
				String name = e.getName();
				String type = e.getType();
				columnData.add(comment + StringUtil.NEW_LINE + name + StringUtil.SPACE + type);
			});
			body.add(columnData.toString());
			body.add(");");

			FileConfig conf = getFileConfig(ExecuteType.DDL);
			conf.setFileName(tableName.toUpperCase() + FileExtension.SQL.getValue());
			conf.setData(body.toString());
			FileFactory.create(conf);
		}
	}

	private Table toTable(List<Row> rowList, String tableName) {
		Table table = new Table();
		table.setPhysicalName(tableName);
		String logicalName = rowList.stream().filter(e -> isTargetTable(e, tableName))
				.map(e -> e.getCell(CellPositionType.LOGICAL_NAME)).collect(Collectors.toList()).get(0)
				.getValue();
		table.setLogicalName(logicalName);
		table.setColumnList(rowList.stream().filter(e -> isTargetTable(e, tableName)).map(e -> {
			Column column = new Column();
			column.setName(getColumnName(e));
			column.setComment(getColumnComment(e));
			column.setType(getColumnType(e));
			return column;
		}).collect(Collectors.toList()));
		return table;
	}

	private String getTableComment(String tableName) {
		return "-- " + tableName;
	}

	private String getColumnComment(Row row) {
		return "-- " + row.getCell(CellPositionType.COLUMN_NAME_COMMENT).getValue();
	}

	private String getColumnName(Row row) {
		return row.getCell(CellPositionType.COLUMN_NAME).getValue();
	}

	private String getColumnType(Row row) {
		StringJoiner body = new StringJoiner(StringUtil.SPACE);
		String columnType = row.getCell(CellPositionType.COLUMN_TYPE).getValue();
		if (isCrypt(row)) {
			columnType = "VARBINARY";
		}
		String size = getSize(row);
		body.add(columnType + size);
		if (isSequence(row)) {
			body.add("AUTO_INCREMENT");
		}
		if (isPrimaryKey(row)) {
			body.add("NOT NULL PRIMARY KEY");
		}
		return body.toString();
	}

	private String getSize(Row row) {
		String size = row.getCell(CellPositionType.COLUMN_SIZE).getValue();
		if (StringUtil.isBrank(size)) {
			return StringUtil.EMPTY;
		} else if (isCrypt(row)) {
			return "(" + String.valueOf(Integer.valueOf(size) * 4) + ")";
		} else {
			return "(" + size + ")";
		}
	}

	private boolean isCrypt(Row row) {
		Predicate<Row> function = e -> CommonFlag.TRUE.is(e.getCell(CellPositionType.CRYPT).getValue());
		return function.test(row);
	}

	private boolean isSequence(Row row) {
		Predicate<Row> function = e -> CommonFlag.TRUE.is(e.getCell(CellPositionType.SEQUENCE).getValue());
		return function.test(row);
	}

	private boolean isPrimaryKey(Row row) {
		Predicate<Row> function = e -> CommonFlag.TRUE.is(e.getCell(CellPositionType.PRIMARY_KEY).getValue());
		return function.test(row);
	}

}
