package jp.co.kin.common.crypt;

import org.springframework.stereotype.Component;

/**
 * crypt.propertiesのBeanクラス
 *
 * @since 1.0.0
 */
@Component
public class CryptComponent {

    /** mode */
    private String mode;
    /** key */
    private String key;

    /**
     * modeを返す
     *
     * @return mode
     *
     */
    public String getMode() {
        return mode;
    }

    /**
     * modeを設定する
     *
     * @param mode
     *     mode
     *
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * keyを返す
     *
     * @return key
     *
     */
    public String getKey() {
        return key;
    }

    /**
     * keyを設定する
     *
     * @param key
     *     key
     *
     */
    public void setKey(String key) {
        this.key = key;
    }

}
