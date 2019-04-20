package jp.co.kin.web.controller;

import org.springframework.web.bind.annotation.RequestBody;

import jp.co.kin.web.request.BaseRequest;
import jp.co.kin.web.response.BaseResponse;

/**
 * API基底コントローラ
 *
 * @param <Rq> リクエスト
 * @param <Rs> レスポンス
 */
public abstract class BaseRestController<Rq extends BaseRequest, Rs extends BaseResponse> {

	public Rs doPost(@RequestBody Rq request) {

	}

	protected abstract Rs execute(Rq request);
}
