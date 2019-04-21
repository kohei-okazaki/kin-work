package jp.co.kin.common.system;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

@Component
public class SystemMemory {

	/**
	 * メモリ使用量を返す
	 *
	 * @return メモリ使用量
	 */
	public String getMemoryUsage() {
		Runtime rt = Runtime.getRuntime();
		DecimalFormat usedFormat = new DecimalFormat("#,###KB");
		Long free = rt.freeMemory() / 1024;
		Long total = rt.totalMemory() / 1024;
		return usedFormat.format(total - free);
	}

	/**
	 * メモリ使用量を%で返す
	 *
	 * @return メモリ使用量(%)
	 */
	public String getMemoryUsageRate() {
		Runtime rt = Runtime.getRuntime();
		DecimalFormat usedFormat = new DecimalFormat("##.#");
		Long free = rt.freeMemory() / 1024;
		Long total = rt.totalMemory() / 1024;
		Long used = total - free;
		double ratio = (used * 100 / total.doubleValue());
		return usedFormat.format(ratio);
	}
}
