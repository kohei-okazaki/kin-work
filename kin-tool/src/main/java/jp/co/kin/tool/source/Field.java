package jp.co.kin.tool.source;

import java.util.List;
import java.util.StringJoiner;

import jp.co.kin.common.util.StringUtil;
import jp.co.kin.tool.type.AccessType;

/**
 * Field
 *
 * @param <T>
 *            任意の型
 */
public class Field<T> {

	/** フィールド名 */
	private String name;
	/** コメント */
	private String comment;
	/** 型 */
	private Class<T> classType;
	/** アクセスタイプ */
	private AccessType accessType;
	/** Annotationリスト */
	private List<Class<?>> annotationList;

	/**
	 * コンストラクタ
	 *
	 * @param name
	 *            フィールド名
	 * @param comment
	 *            コメント
	 * @param classType
	 *            型
	 * @param annotationList
	 *            Annotationリスト
	 */
	public Field(String name, String comment, Class<T> classType, List<Class<?>> annotationList) {
		this(name, comment, classType, AccessType.PRIVATE, annotationList);
	}

	/**
	 * コンストラクタ
	 *
	 * @param name
	 *            フィールド名
	 * @param comment
	 *            コメント
	 * @param classType
	 *            型
	 * @param accessType
	 *            アクセスタイプ
	 * @param annotationList
	 *            Annotationリスト
	 */
	public Field(String name, String comment, Class<T> classType, AccessType accessType,
			List<Class<?>> annotationList) {
		this.name = name;
		this.comment = comment;
		this.classType = classType;
		this.accessType = accessType;
		this.annotationList = annotationList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final String TAB = "	";

		/* JavaDoc作成 */
		String javadocPrefix = "/**";
		String javadocSuffix = "*/";
		StringJoiner javadocBody = new StringJoiner(StringUtil.SPACE);
		javadocBody.add(javadocPrefix);
		javadocBody.add(this.comment);
		javadocBody.add(javadocSuffix);
		String javadoc = TAB + javadocBody.toString();

		/* annotation作成 */
		StringJoiner annotationBody = new StringJoiner(StringUtil.NEW_LINE);
		annotationList.stream().forEach(e -> {
			annotationBody.add("@" + e.getClass());
		});

		/* field作成 */
		StringJoiner fieldBody = new StringJoiner(StringUtil.SPACE);
		fieldBody.add(this.accessType.getValue());
		fieldBody.add(this.classType.getSimpleName());
		fieldBody.add(this.name);
		String field = TAB + fieldBody.toString() + ";";
		return javadoc + StringUtil.NEW_LINE + field;
	}

	/**
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定する
	 *
	 * @param name
	 *            名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * commentを返す
	 *
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * commentを設定する
	 *
	 * @param comment
	 *            コメント
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * classTypeを返す
	 *
	 * @return classType
	 */
	public Class<?> getClassType() {
		return classType;
	}

	/**
	 * classTypeを設定する
	 *
	 * @param classType
	 *            クラス型
	 */
	public void setClassType(Class<T> classType) {
		this.classType = classType;
	}

	/**
	 * accessTypeを返す
	 *
	 * @return accessType
	 */
	public AccessType getAccessType() {
		return accessType;
	}

	/**
	 * accessTypeを設定する
	 *
	 * @param accessType
	 *            アクセスタイプ
	 */
	public void setAccessType(AccessType accessType) {
		this.accessType = accessType;
	}

}
