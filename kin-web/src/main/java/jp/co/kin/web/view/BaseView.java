package jp.co.kin.web.view;

import jp.co.kin.common.type.BaseEnum;

/**
 * ViewEnumの基底インターフェース<br>
 * すべてのViewEnumはこのインターフェースを継承すること
 */
public interface BaseView extends BaseEnum {

	/**
	 * 名前を返す
	 *
	 * @return name
	 */
	String getName();

}
