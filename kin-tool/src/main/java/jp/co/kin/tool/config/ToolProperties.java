package jp.co.kin.tool.config;

import jp.co.kin.common.io.file.property.annotation.Property;

/**
 * tool.proertiesのBean
 * 
 * @since 1.0.0
 */
public class ToolProperties {

	@Property(name = "targetTable")
	private String targetTable;
	@Property(name = "baseDir")
	private String baseDir;

	/**
	 * targetTableを返す
	 *
	 * @return targetTable
	 */
	public String getTargetTable() {
		return targetTable;
	}

	/**
	 * targetTableを設定する
	 *
	 * @param targetTable
	 *            対象テーブル
	 */
	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}

	/**
	 * baseDirを返す
	 *
	 * @return baseDir
	 */
	public String getBaseDir() {
		return baseDir;
	}

	/**
	 * baseDirを設定する
	 *
	 * @param baseDir
	 *            基底ディレクトリ
	 */
	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

}
