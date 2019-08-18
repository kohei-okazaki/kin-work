package jp.co.kin.common.io.file.csv.writer;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import jp.co.kin.common.bean.BaseDto;
import jp.co.kin.common.io.file.csv.annotation.CsvColumn;
import jp.co.kin.common.io.file.csv.annotation.CsvEntity;
import jp.co.kin.common.io.file.csv.dto.CsvConfig;
import jp.co.kin.common.io.file.csv.dto.CsvWriteResult;
import jp.co.kin.common.util.BeanUtil;

/**
 * CSV書き込みクラス<br>
 * ex)<br>
 * <code>
 * Hoge hoge = new Hoge();<br>
 * CsvResult result = new CsvWriter().setConfig(config).write(hoge);<br>
 * if (result.hasError()) {<br>
 * // error処理<br>
 * }<br>
 * </code>
 *
 */
public class CsvWriter {

	/** CSV設定情報 */
	private CsvConfig conf;

	/**
	 * confを設定する<br>
	 * conf Methodチェイン用に自身を返却すること
	 *
	 * @param conf
	 *            conf
	 */
	public CsvWriter setConfig(CsvConfig conf) {
		this.conf = conf;
		return this;
	}

	public CsvWriteResult write(Object bean) {

		CsvWriteResult result = new CsvWriteResult();

		if (!isCsvEntity(bean)) {
			result.setHasError(true);
			result.setErrorMessage("CSV出力対象Entityに@CsvEntityを付与してください");
			return result;
		}

		List<CsvUnitDto> orderList = getCsvOrder(bean);

		// TODO CSVに実際に書き込む処理を追加
		return result;
	}

	private static boolean isCsvEntity(Object bean) {
		return bean.getClass().isAnnotationPresent(CsvEntity.class);
	}

	private static List<CsvUnitDto> getCsvOrder(Object bean) {

		List<CsvUnitDto> csvDtoList = BeanUtil.getFieldList(bean.getClass()).stream().map(e -> {

			CsvUnitDto csvUnitDto = new CsvUnitDto();
			CsvColumn column = e.getAnnotation(CsvColumn.class);

			csvUnitDto.setOrder(column.order());
			csvUnitDto.setField(e);
			csvUnitDto.setLabel(column.label());

			return csvUnitDto;
		}).collect(Collectors.toList());

		// orderの昇順にソート
		return csvDtoList.stream().sorted(Comparator.comparing(CsvUnitDto::getOrder))
				.collect(Collectors.toList());
	}

	private static class CsvUnitDto implements BaseDto {

		/** 表示順 */
		private Integer order;
		/** フィールド名 */
		private Field field;
		/** ラベル名 */
		private String label;

		/**
		 * orderを返す
		 *
		 * @return order
		 *
		 */
		public Integer getOrder() {
			return order;
		}

		/**
		 * orderを設定する
		 *
		 * @param order
		 *            order
		 *
		 */
		public void setOrder(Integer order) {
			this.order = order;
		}

		/**
		 * fieldを返す
		 *
		 * @return field
		 *
		 */
		public Field getField() {
			return field;
		}

		/**
		 * fieldを設定する
		 *
		 * @param field
		 *            field
		 *
		 */
		public void setField(Field field) {
			this.field = field;
		}

		/**
		 * labelを返す
		 *
		 * @return label
		 *
		 */
		public String getLabel() {
			return label;
		}

		/**
		 * labelを設定する
		 *
		 * @param label
		 *            label
		 *
		 */
		public void setLabel(String label) {
			this.label = label;
		}

	}

}
