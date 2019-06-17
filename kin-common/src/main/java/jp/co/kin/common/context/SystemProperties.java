package jp.co.kin.common.context;

import org.springframework.stereotype.Component;

@Component
public class SystemProperties {

	/** loglevel */
	private String loglevel;
	/** ページング */
	private String paging;

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
