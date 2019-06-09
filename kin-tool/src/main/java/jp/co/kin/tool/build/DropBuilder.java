package jp.co.kin.tool.build;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import jp.co.kin.common.util.CollectionUtil;
import jp.co.kin.common.util.FileUtil.FileExtension;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.build.annotation.Build;
import jp.co.kin.tool.config.FileConfig;
import jp.co.kin.tool.db.Table;
import jp.co.kin.tool.excel.Excel;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.factory.FileFactory;
import jp.co.kin.tool.type.CellPositionType;
import jp.co.kin.tool.type.ExecuteType;

public class DropBuilder extends BaseBuilder {

	@Build
	public void execute() {

		Excel excel = super.reader.read();
		excel.activeSheet("TABLE_LIST");

		List<Table> tableList = getTableList(excel.getRowList());
		StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
		tableList.stream().forEach(e -> {
			body.add(buildComment(e.getLogicalName()));
			body.add(buildDropSql(e.getPhysicalName()));
		});

		FileConfig conf = getFileConfig(ExecuteType.DROP);
		conf.setFileName("DROP" + FileExtension.SQL.getValue());
		conf.setData(body.toString());
		FileFactory.create(conf);
	}

	private List<Table> getTableList(List<Row> rowList) {
		// header行を除外
		List<Row> list = CollectionUtil.copyList(rowList);
		list.remove(0);
		List<Table> tableList = new ArrayList<>();
		List<String> existTableList = new ArrayList<>();
		for (Row row : list) {
			String logicalName = row.getCell(CellPositionType.LOGICAL_NAME).getValue();
			String physicalName = row.getCell(CellPositionType.PHYSICAL_NAME).getValue();
			if (!containsTable(existTableList, physicalName) && !StringUtil.isEmpty(physicalName)) {
				existTableList.add(physicalName);
				Table table = new Table();
				table.setLogicalName(logicalName);
				table.setPhysicalName(physicalName);
				tableList.add(table);
			}
		}
		return tableList;
	}

	private boolean containsTable(List<String> tableList, String tblName) {
		return tableList.contains(tblName);
	}

	private String buildDropSql(String physicalName) {
		String prefix = "DROP TABLE ";
		String suffix = ";";
		return prefix + physicalName + suffix;
	}

	private String buildComment(String logicalName) {
		String prefix = "-- ";
		return prefix + logicalName;
	}

}
