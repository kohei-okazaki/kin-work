package jp.co.kin.tool.build;

public class ToolExecutor {

	/**
	 * 実行したいビルダークラスをjp.co.kin.tool.build.BuildInvoker#buildの引数に設定して下さい
	 * <ul>
	 * <li>EntityBuilder</li>
	 * <li>CreateTableBuilder</li>
	 * </ul>
	 *
	 * @param args
	 *            使わない
	 */
	public static void main(String[] args) {
		BuildInvoker.build("CreateTableBuilder", "EntityBuilder");
	}
}
