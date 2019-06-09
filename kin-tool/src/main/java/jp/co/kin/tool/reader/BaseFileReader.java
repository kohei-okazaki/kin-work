package jp.co.kin.tool.reader;

import java.io.File;

import jp.co.kin.common.util.FileUtil;
import jp.co.kin.common.util.FileUtil.FileSeparator;

public abstract class BaseFileReader {

	/**
	 * 指定したパスからファイルを返す
	 *
	 * @param resourcePath
	 *            パス
	 * @return File
	 */
	protected File getFile(String resourcePath) {
		String sysPath = this.getClass().getClassLoader().getResource("").getPath();
		return FileUtil.getFile(sysPath + FileSeparator.SYSTEM.getValue() + resourcePath);
	}

}
