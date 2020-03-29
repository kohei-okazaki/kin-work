package jp.co.kin.common.io.file.json.reader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.kin.common.exception.CommonErrorCode;
import jp.co.kin.common.exception.SystemException;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;

/**
 * JSONファイルのReaderクラス
 *
 * @since 1.0.0
 */
public class JsonReader {

    private static final Logger LOG = LoggerFactory.getLogger(JsonReader.class);

    /**
     * 指定されたファイルパスからJavaオブジェクトに変換する
     *
     * @param <T>
     *     変換後のJavaクラス型
     * @param path
     *     ファイルパス
     * @param fileName
     *     ファイル名
     * @param clazz
     *     変換後のJavaクラス型
     * @return Javaオブジェクト
     */
    public <T> T read(String path, String fileName, Class<T> clazz) {
        return read(new File(path, fileName), clazz);
    }

    /**
     * 指定されたJSONからJSONオブジェクトに変換する
     *
     * @param <T>
     *     変換後のJavaクラス型
     * @param json
     *     JSONファイル
     * @param clazz
     *     変換後のJavaクラス型
     * @return JSONオブジェクト
     */
    public <T> T read(File json, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(json, clazz);
        } catch (JsonParseException e) {
            LOG.error(json.getName() + "をjavaクラスへのParseに失敗しました", e);
            throw new SystemException(CommonErrorCode.UNEXPECTED,
                    json.getName() + "のParseに失敗しました");
        } catch (JsonMappingException e) {
            LOG.error(json.getName() + "をjavaクラスへのMappingに失敗しました", e);
            throw new SystemException(CommonErrorCode.UNEXPECTED,
                    json.getName() + "のMappingに失敗しました");
        } catch (IOException e) {
            LOG.error("JSONの読込に失敗しました", e);
            throw new SystemException(CommonErrorCode.UNEXPECTED,
                    json.getName() + "JSONの読込に失敗しました");
        }
    }

    /**
     * 指定されたJSON文字列からJSONオブジェクトに変換する
     *
     * @param <T>
     *     変換後のJavaクラス型
     * @param strJson
     *     文字列型のJSON
     * @param clazz
     *     変換後のJavaクラス型
     * @return JSONオブジェクト
     */
    public <T> T read(String strJson, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(strJson, clazz);
        } catch (JsonParseException e) {
            LOG.error(strJson + "のParseに失敗しました", e);
            throw new SystemException(CommonErrorCode.UNEXPECTED,
                    strJson + "のParseに失敗しました");
        } catch (JsonMappingException e) {
            LOG.error(strJson + "のMappingに失敗しました", e);
            throw new SystemException(CommonErrorCode.UNEXPECTED,
                    strJson + "のMappingに失敗しました");
        } catch (IOException e) {
            LOG.error("JSONの読込に失敗しました", e);
            throw new SystemException(CommonErrorCode.UNEXPECTED,
                    strJson + "JSONの読込に失敗しました");
        }
    }

    /**
     * 指定されたJavaBeanをJSON文字列に変換する
     *
     * @param bean
     *     Bean
     * @return JSON文字列
     */
    public String read(Object bean) {
        try {
            return new ObjectMapper().writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            LOG.error("JSON文字列への書き出しに失敗しました", e);
            throw new SystemException(CommonErrorCode.UNEXPECTED, "JSON文字列への書き出しに失敗しました");
        }
    }
}
