package jp.co.kin.common.io.file.property.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import jp.co.kin.common.io.file.property.annotation.Property;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.common.util.BeanUtil;
import jp.co.kin.common.util.BeanUtil.AccessorType;
import jp.co.kin.common.util.CollectionUtil;
import jp.co.kin.common.util.FileUtil.FileSeparator;

/**
 * PropertiesファイルのReader
 *
 * @since 1.0.0
 */
public class PropertyReader {

    /** LOG */
    private static final Logger LOG = LoggerFactory.getLogger(PropertyReader.class);

    /**
     * 指定したパスのプロパティファイルの読み込みを行う
     *
     * @param path
     *     ファイルパス
     * @param fileName
     *     ファイル名
     * @return Properties
     */
    public Properties read(String path, String fileName) {

        LOG.debug(fileName + "の読込 開始");

        Properties prop = new Properties();
        try (InputStream is = new FileInputStream(
                path + FileSeparator.SYSTEM.getValue() + fileName)) {
            prop.load(is);
        } catch (FileNotFoundException e) {
            LOG.error("プロパティファイル読込エラー ファイル名=" + fileName, e);
        } catch (IOException e) {
            LOG.error("読込エラー", e);
        } finally {
            LOG.debug(fileName + "の読込 終了");
        }
        return prop;
    }

    /**
     * 指定したパスのプロパティを読み取り、対応するBeanを返す
     *
     * @param path
     *     ファイルパス
     * @param fileName
     *     ファイル名
     * @param clazz
     *     bean
     * @return 対応するBean
     */
    public <T> T read(String path, String fileName, Class<T> clazz) {
        Properties prop = read(path, fileName);
        try {
            T t = clazz.getDeclaredConstructor().newInstance();

            for (String name : getPropNameList(clazz)) {
                Method setter = BeanUtil.getAccessor(name, clazz, AccessorType.SETTER);
                Object value = prop.get(name);
                setter.invoke(t, value);
            }
            return t;

        } catch (InstantiationException e) {
            LOG.error("インスタンスの生成に失敗しました", e);
        } catch (IllegalAccessException e) {
            LOG.error("アクセス修飾子が不正です", e);
        } catch (IllegalArgumentException e) {
            LOG.error("constructor or setterの引数が不正です", e);
        } catch (InvocationTargetException e) {
            LOG.error("constructor or setterの処理に失敗しました", e);
        } catch (NoSuchMethodException e) {
            LOG.error("setterが存在しません", e);
        } catch (SecurityException e) {
            LOG.error("インスタンスの生成に失敗しました", e);
        }
        return null;
    }

    /**
     * 指定したクラス型のフィールドに付与されている<code>@Propery</code>のnameをリストにして返す
     *
     * @param clazz
     *     対象クラス
     * @return nameリスト
     */
    private static List<String> getPropNameList(Class<?> clazz) {
        return CollectionUtil.toList(clazz.getDeclaredFields()).stream()
                .filter(e -> e.isAnnotationPresent(Property.class))
                .map(e -> e.getAnnotation(Property.class).name())
                .collect(Collectors.toList());
    }

}
