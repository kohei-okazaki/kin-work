package jp.co.kin.common.io.file.json.reader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.kin.common.exception.BaseException;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;

public class JsonReader {

	private static final Logger LOG = LoggerFactory.getLogger(JsonReader.class);

	/**
	 * 指定されたファイルパスからJavaオブジェクトに変換する
	 *
	 * @param <T>
	 *            変換後のJavaクラス型
	 * @param path
	 *            ファイルパス
	 * @param fileName
	 *            ファイル名
	 * @param clazz
	 *            変換後のJavaクラス型
	 * @return
	 */
	public <T> T read(String path, String fileName, Class<T> clazz) {
		return read(new File(path, fileName), clazz);
	}

	/**
	 * 指定されたJSONからJSONオブジェクトに変換する
	 *
	 * @param <T>
	 *            変換後のJavaクラス型
	 * @param json
	 *            JSONファイル
	 * @param clazz
	 *            変換後のJavaクラス型
	 * @return
	 */
	public <T> T read(File json, Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(json, clazz);
		} catch (JsonParseException e) {
			LOG.error(json.getName() + "をjavaクラスへのParseに失敗しました", e);
		} catch (JsonMappingException e) {
			LOG.error(json.getName() + "をjavaクラスへのMappingに失敗しました", e);
		} catch (IOException e) {
			LOG.error("JSONの読込に失敗しました", e);
		}
		return null;
	}

	/**
	 * 指定されたJSONからJSONオブジェクトに変換する
	 *
	 * @param <T>
	 *            変換後のJavaクラス型
	 * @param strJson
	 *            文字列型のJSON
	 * @param clazz
	 *            変換後のJavaクラス型
	 * @return
	 */
	public <T> T read(String strJson, Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(strJson, clazz);
		} catch (JsonParseException e) {
			LOG.error(strJson + "をjavaクラスへのParseに失敗しました", e);
		} catch (JsonMappingException e) {
			LOG.error(strJson + "をjavaクラスへのMappingに失敗しました", e);
		} catch (IOException e) {
			LOG.error("JSONの読込に失敗しました", e);
		}
		return null;
	}

	/**
	 * 指定されたJavaBeanをJSON文字列に変換する
	 *
	 * @param bean
	 *            Bean
	 * @return JSON文字列
	 * @throws BaseException
	 *             基底例外
	 */
	public String read(Object bean) throws BaseException {
		try {
			return new ObjectMapper().writeValueAsString(bean);
		} catch (JsonProcessingException e) {
			LOG.error("", e);
			return null;
		}
	}
}
