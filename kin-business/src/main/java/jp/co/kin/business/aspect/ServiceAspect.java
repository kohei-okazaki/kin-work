package jp.co.kin.business.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;

/**
 * Serviceクラスの前後に呼ばれるAspect
 *
 */
@Aspect
@Component
public class ServiceAspect {

	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(ServiceAspect.class);

	@Around("execution(* jp.co.kin.business.*.service.impl.*Impl.*(..))")
	public Object executeLog(ProceedingJoinPoint pjp) throws Throwable {

		String serviceName = pjp.getThis().getClass().getName();
		LOG.info(serviceName + " called...");
		Object o = pjp.proceed();
		LOG.info(serviceName + " success");

		return o;
	}
}
