package jp.co.kin.common.context;

import org.springframework.stereotype.Component;

/**
 * system.proertiesのBeanクラス
 *
 */
@Component
public class SystemProperties {

	private String loglevel;

	/**
	 * loglevelを返す
	 *
	 * @return loglevel
	 *
	 */
	public String getLoglevel() {
		return loglevel;
	}

	/**
	 * loglevelを設定する
	 *
	 * @param loglevel
	 *            ログレベル
	 */
	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

}
