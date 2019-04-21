package jp.co.kin.common.db;

public class JdbcConfig {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	private JdbcConfig() {
	}

	/**
	 * driverClassNameを返す
	 *
	 * @return driverClassName
	 *
	 */
	public String getDriverClassName() {
		return driverClassName;
	}

	/**
	 * @param driverClassName
	 *            driverClassNameを設定する
	 *
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	/**
	 * urlを返す
	 *
	 * @return url
	 *
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            urlを設定する
	 *
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * usernameを返す
	 *
	 * @return username
	 *
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            usernameを設定する
	 *
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * passwordを返す
	 *
	 * @return password
	 *
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            passwordを設定する
	 *
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
