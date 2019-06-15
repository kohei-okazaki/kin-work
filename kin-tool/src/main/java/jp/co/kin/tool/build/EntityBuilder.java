package jp.co.kin.tool.build;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

import jp.co.kin.common.log.annotation.Mask;
import jp.co.kin.common.type.LineFeedType;
import jp.co.kin.common.util.FileUtil.FileExtension;
import jp.co.kin.common.util.StringUtil;
import jp.co.kin.db.annotation.Crypt;
import jp.co.kin.db.entity.BaseEntity;
import jp.co.kin.tool.build.annotation.Build;
import jp.co.kin.tool.config.FileConfig;
import jp.co.kin.tool.excel.Cell;
import jp.co.kin.tool.excel.Excel;
import jp.co.kin.tool.excel.Row;
import jp.co.kin.tool.factory.FileFactory;
import jp.co.kin.tool.source.Field;
import jp.co.kin.tool.source.Getter;
import jp.co.kin.tool.source.Import;
import jp.co.kin.tool.source.JavaSource;
import jp.co.kin.tool.source.Setter;
import jp.co.kin.tool.type.AccessType;
import jp.co.kin.tool.type.CellPositionType;
import jp.co.kin.tool.type.ClassType;
import jp.co.kin.tool.type.ColumnType;
import jp.co.kin.tool.type.ExecuteType;

public class EntityBuilder extends SourceBuilder {

	@Build
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute() {

		Excel excel = super.reader.read();
		excel.activeSheet("TABLE_LIST");

		for (String table : this.targetTableList) {
			JavaSource source = new JavaSource();
			setCommonInfo(source);
			for (Row row : excel.getRowList()) {

				if (!isTargetTable(row, table)) {
					continue;
				}
				source.setClassName(toJavaFileName(getPhysicalName(row)));

				// fieldの設定
				Field<?> field = new Field(toCamelCase(getFieldName(row)), getColumnComment(row),
						getClassType(row), getFieldAnnotationMap(row, source));
				source.addField(field);

				// fieldのimport文を設定
				Import im = new Import(field);
				source.addImport(im);

				// setterの設定
				Setter<?> setter = new Setter(field);
				source.addMethod(setter);

				// getterの設定
				Getter<?> getter = new Getter(field);
				source.addMethod(getter);
			}

			FileConfig fileConf = getFileConfig(ExecuteType.ENTITY);
			fileConf.setFileName(toJavaFileName(table) + FileExtension.JAVA.getValue());
			fileConf.setData(build(source));
			FileFactory.create(fileConf);
		}
	}

	private Map<Class<?>, String> getFieldAnnotationMap(Row row, JavaSource source) {

		Map<Class<?>, String> map = new HashMap<>();
		Cell primaryKeyCell = row.getCell(CellPositionType.PRIMARY_KEY);
		if (StringUtil.hasValue(primaryKeyCell.getValue())) {
			map.put(Id.class, "");
			source.addImport(new Import(Id.class));
		}
		Cell sequenceCell = row.getCell(CellPositionType.SEQUENCE);
		if (StringUtil.hasValue(sequenceCell.getValue())) {
			map.put(GeneratedValue.class, "strategy = GenerationType.SEQUENCE");
			source.addImport(new Import(GeneratedValue.class));
		}
		Cell cryptCell = row.getCell(CellPositionType.CRYPT);
		if (StringUtil.hasValue(cryptCell.getValue())) {
			map.put(Mask.class, "");
			source.addImport(new Import(Mask.class));

			map.put(Crypt.class, "");
			source.addImport(new Import(Crypt.class));
		}
		return map;
	}

	private String getColumnComment(Row row) {
		return row.getCell(CellPositionType.COLUMN_NAME_COMMENT).getValue();
	}

	/**
	 * 共通情報を設定する
	 *
	 * @param source
	 *            JavaSource
	 */
	private void setCommonInfo(JavaSource source) {
		source.setPackage(new jp.co.kin.tool.source.Package("jp.co.kin.db.entity"));
		source.setClassType(ClassType.CLASS);
		source.setAccessType(AccessType.PUBLIC);
		source.setExtendsClass(BaseEntity.class);
		source.addImport(new Import(BaseEntity.class));
		source.addClassAnnotation(Entity.class, "(naming = NamingType.SNAKE_UPPER_CASE)");
		source.addImport(new Import(Entity.class));
		source.addImport(new Import(NamingType.class));
	}

	private String getFieldName(Row row) {
		return row.getCell(CellPositionType.COLUMN_NAME).getValue();
	}

	private Class<?> getClassType(Row row) {
		String columnType = row.getCell(CellPositionType.COLUMN_TYPE).getValue();
		return ColumnType.of(columnType).getClassType();
	}

	private String build(JavaSource source) {
		StringJoiner result = new StringJoiner(LineFeedType.CRLF.getValue() + LineFeedType.CRLF.getValue());

		// package情報
		result.add(buildPackage(source));

		// import情報
		result.add(buildImport(source.getImportList()));

		// class情報
		result.add(
				buildClassAnnotation(source.getClassAnnotationMap()) + LineFeedType.CRLF.getValue()
						+ buildClass(source) + buildExtendsClass(source) + buildInterfaces(source) + " {");

		// field情報
		result.add(buildFields(source.getFieldList()));

		// method情報
		result.add(buildMethods(source.getMethodList()));

		result.add("}");

		return result.toString();
	}

	private String buildFields(List<Field<?>> fieldList) {
		StringJoiner body = new StringJoiner(StringUtil.NEW_LINE);
		fieldList.stream().forEach(e -> body.add(e.toString()));
		return body.toString();
	}

}
