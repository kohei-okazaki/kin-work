package jp.co.kin.common.exception;

import jp.co.kin.common.log.type.LogLevel;

/**
 * エラーコードの基底インターフェース<br>
 * 各アプリケーションで本インターフェースを継承した列挙クラスを作成すること<br>
 * 以下のフォーマットでエラーコードとする<br>
 * ABCDEF<br>
 * <ul>
 * <li>A:エラーレベル</li>
 * <li>B:機能名</li>
 * <li>CDEF:採番</li>
 * </ul>
 *
 * @since 1.0.0
 */
public interface BaseErrorCode {

    /**
     * エラーコード(外部用)を返却
     *
     * @return エラーコード(外部用)
     */
    String getOuterErrorCode();

    /**
     * ログレベルを返却
     *
     * @return ログレベル
     */
    LogLevel getLogLevel();

}
