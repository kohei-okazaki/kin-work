package jp.co.kin.web.view;

/**
 * ViewEnumの基底インターフェース<br>
 * すべてのViewEnumはこのインターフェースを継承すること
 */
public interface BaseView {

	/**
	 * 名前を返す
	 *
	 * @return name
	 */
	String getName();
}