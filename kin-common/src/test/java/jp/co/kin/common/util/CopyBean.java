package jp.co.kin.common.util;

import java.util.Date;

public class CopyBean {

	private String name;
	private int num;
	private Date date;

	/**
	 * nameを返す
	 *
	 * @return name
	 *
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定する
	 *
	 * @param name
	 *            name
	 *
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * numを返す
	 *
	 * @return num
	 *
	 */
	public int getNum() {
		return num;
	}

	/**
	 * numを設定する
	 *
	 * @param num
	 *            num
	 *
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * dateを返す
	 *
	 * @return date
	 *
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * dateを設定する
	 *
	 * @param date
	 *            date
	 *
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
