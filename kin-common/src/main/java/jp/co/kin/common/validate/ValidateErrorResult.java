package jp.co.kin.common.validate;

import java.util.ArrayList;
import java.util.List;

import jp.co.kin.common.util.CollectionUtil;

public class ValidateErrorResult {

	/** 妥当性チェックのリスト */
	private List<ValidateError> errorList;

	public ValidateErrorResult() {
		this.errorList = new ArrayList<>();
	}

	public void add(ValidateError error) {
		this.errorList.add(error);
	}

	public boolean hasError() {
		return CollectionUtil.exists(errorList);
	}

	public ValidateError getFirst() {
		return CollectionUtil.getFirst(errorList);
	}
}
