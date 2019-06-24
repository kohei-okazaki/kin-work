package jp.co.kin.common.io.file.csv.dto;

import jp.co.kin.common.bean.BaseDto;
import jp.co.kin.common.type.Charset;

public class CsvConfig implements BaseDto {

	private Charset charset;
	private String filePath;
	private String fileName;

	/**
	 * charsetを返す
	 * 
	 * @return charset
	 *
	 */
	public Charset getCharset() {
		return charset;
	}

	/**
	 * charsetを設定する
	 * 
	 * @param charset
	 *            charset
	 *
	 */
	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	/**
	 * filePathを返す
	 * 
	 * @return filePath
	 *
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * filePathを設定する
	 * 
	 * @param filePath
	 *            filePath
	 *
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * fileNameを返す
	 * 
	 * @return fileName
	 *
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * fileNameを設定する
	 * 
	 * @param fileName
	 *            fileName
	 *
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
