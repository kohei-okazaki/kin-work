package jp.co.kin.common.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;

public abstract class BaseExceptionHander implements HandlerExceptionResolver {

	private static final Logger LOG = LoggerFactory.getLogger(BaseExceptionHander.class);

}
