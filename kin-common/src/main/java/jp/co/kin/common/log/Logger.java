package jp.co.kin.common.log;

import org.springframework.stereotype.Component;

/**
 * Logger
 */
@Component
public class Logger {

	/* DEBUG */
	/**
	 * Debugログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param bean
	 *            Bean
	 */
	public void debugRes(Class<?> clazz, Object bean) {
		org.slf4j.LoggerFactory.getLogger(clazz).debug(LogMessageFactory.getLogMessage(bean));
	}

	/**
	 * Debugログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param msg
	 *            ログメッセージ
	 */
	public void debug(Class<?> clazz, String msg) {
		org.slf4j.LoggerFactory.getLogger(clazz).debug(msg);
	}

	/* INFO */
	/**
	 * Infoログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param bean
	 *            Bean
	 */
	public void infoRes(Class<?> clazz, Object bean) {
		org.slf4j.LoggerFactory.getLogger(clazz).info(LogMessageFactory.getLogMessage(bean));
	}

	/**
	 * Infoログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param msg
	 *            ログメッセージ
	 */
	public void info(Class<?> clazz, String msg) {
		org.slf4j.LoggerFactory.getLogger(clazz).info(msg);
	}

	/* WARN */
	/**
	 * Warnログを出力する
	 *
	 * @param bean
	 *            Bean
	 */
	public void warnRes(Class<?> clazz, Object bean) {
		org.slf4j.LoggerFactory.getLogger(clazz).warn(LogMessageFactory.getLogMessage(bean));
	}

	/**
	 * Warnログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param bean
	 *            Bean
	 * @param t
	 *            例外
	 */
	public void warnRes(Class<?> clazz, Object bean, Throwable t) {
		org.slf4j.LoggerFactory.getLogger(clazz).warn(LogMessageFactory.getLogMessage(bean), t);
	}

	/**
	 * Warnログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param msg
	 *            ログメッセージ
	 */
	public void warn(Class<?> clazz, String msg) {
		org.slf4j.LoggerFactory.getLogger(clazz).warn(msg);
	}

	/**
	 * Warnログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param msg
	 *            ログメッセージ
	 * @param t
	 *            例外
	 */
	public void warn(Class<?> clazz, String msg, Throwable t) {
		org.slf4j.LoggerFactory.getLogger(clazz).warn(msg, t);
	}

	/* ERROR */
	/**
	 * Errorログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param bean
	 *            Bean
	 */
	public void errorRes(Class<?> clazz, Object bean) {
		org.slf4j.LoggerFactory.getLogger(clazz).error(LogMessageFactory.getLogMessage(bean));
	}

	/**
	 * Errorログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param bean
	 *            Bean
	 * @param t
	 *            例外
	 */
	public void errorRes(Class<?> clazz, Object bean, Throwable t) {
		org.slf4j.LoggerFactory.getLogger(clazz).error(LogMessageFactory.getLogMessage(bean), t);
	}

	/**
	 * Errorログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param msg
	 *            ログメッセージ
	 */
	public void error(Class<?> clazz, String msg) {
		org.slf4j.LoggerFactory.getLogger(clazz).error(msg);
	}

	/**
	 * Errorログを出力する
	 *
	 * @param clazz
	 *            対象クラス
	 * @param msg
	 *            ログメッセージ
	 * @param t
	 *            例外
	 */
	public void error(Class<?> clazz, String msg, Throwable t) {
		org.slf4j.LoggerFactory.getLogger(clazz).error(msg, t);
	}
}
