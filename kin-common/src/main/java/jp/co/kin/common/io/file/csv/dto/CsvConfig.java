package jp.co.kin.common.io.file.csv.dto;

import jp.co.kin.common.bean.BaseDto;
import jp.co.kin.common.io.file.BaseFileConfig;

/**
 * CSVファイル設定情報
 *
 */
public class CsvConfig extends BaseFileConfig implements BaseDto {

	/** 囲い文字 */
	private String fileChar;

	/**
	 * fileCharを返す
	 * 
	 * @return fileChar
	 *
	 */
	public String getFileChar() {
		return fileChar;
	}

	/**
	 * fileCharを設定する
	 * 
	 * @param fileChar
	 *            fileChar
	 *
	 */
	public void setFileChar(String fileChar) {
		this.fileChar = fileChar;
	}

}
