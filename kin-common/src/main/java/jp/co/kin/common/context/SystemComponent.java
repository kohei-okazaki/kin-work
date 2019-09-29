package jp.co.kin.common.context;

import org.springframework.stereotype.Component;

import jp.co.kin.common.log.type.LogLevel;

/**
 * system.propertiesのBeanクラス
 *
 */
@Component
public class SystemComponent {

	/** loglevel */
	private LogLevel loglevel;
	/** ページング */
	private String paging;

	/**
	 * loglevelを返す
	 *
	 * @return loglevel
	 *
	 */
	public LogLevel getLoglevel() {
		return loglevel;
	}

	/**
	 * loglevelを設定する
	 *
	 * @param loglevel
	 *            loglevel
	 *
	 */
	public void setLoglevel(String loglevel) {
		this.loglevel = LogLevel.of(loglevel);
	}

	/**
	 * pagingを返す
	 *
	 * @return paging
	 *
	 */
	public String getPaging() {
		return paging;
	}

	/**
	 * pagingを設定する
	 *
	 * @param paging
	 *            paging
	 *
	 */
	public void setPaging(String paging) {
		this.paging = paging;
	}

}
