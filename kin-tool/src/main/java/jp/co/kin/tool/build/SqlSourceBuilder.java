package jp.co.kin.tool.build;

import java.util.StringJoiner;
import java.util.function.Predicate;

import jp.co.kin.common.type.CommonFlag;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.type.CellPositionType;

/**
 * SqlSourceBuilder
 * 
 * @since 1.0.0
 *
 */
public abstract class SqlSourceBuilder extends BaseBuilder {

	protected boolean isCrypt(Row row) {
		Predicate<Row> function = e -> CommonFlag.TRUE.is(e.getCell(CellPositionType.CRYPT).getValue());
		return function.test(row);
	}

	protected boolean isSequence(Row row) {
		Predicate<Row> function = e -> CommonFlag.TRUE.is(e.getCell(CellPositionType.SEQUENCE).getValue());
		return function.test(row);
	}

	protected boolean isPrimaryKey(Row row) {
		Predicate<Row> function = e -> CommonFlag.TRUE.is(e.getCell(CellPositionType.PRIMARY_KEY).getValue());
		return function.test(row);
	}

	protected String getColumnType(Row row) {
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

	protected String getSize(Row row) {
		String size = row.getCell(CellPositionType.COLUMN_SIZE).getValue();
		if (StringUtil.isBrank(size)) {
			return StringUtil.EMPTY;
		} else if (isCrypt(row)) {
			return "(" + String.valueOf(Integer.valueOf(size) * 4) + ")";
		} else {
			return "(" + size + ")";
		}
	}

	protected String getTableComment(String tableName) {
		return "-- " + tableName;
	}

	protected String getColumnComment(Row row) {
		return "-- " + row.getCell(CellPositionType.COLUMN_NAME_COMMENT).getValue();
	}

	protected String getColumnName(Row row) {
		return row.getCell(CellPositionType.COLUMN_NAME).getValue();
	}
}
