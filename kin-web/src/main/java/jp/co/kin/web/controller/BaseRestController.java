package jp.co.kin.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jp.co.kin.web.request.BaseRequest;
import jp.co.kin.web.response.BaseResponse;

/**
 * API基底コントローラ
 *
 * @param <Rq>
 *            リクエスト
 * @param <Rs>
 *            レスポンス
 */
public abstract class BaseRestController<Rq extends BaseRequest, Rs extends BaseResponse> {

	@PostMapping(headers = { "Content-type=application/json;charset=UTF-8" }, produces = {
	        MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Rs doPost(@RequestBody Rq request) {
		Rs response = execute(request);
		return response;
	}

	protected abstract Rs execute(Rq request);
}
