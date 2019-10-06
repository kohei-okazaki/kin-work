package jp.co.kin.business.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jp.co.kin.common.crypt.Crypter;
import jp.co.kin.common.log.Logger;
import jp.co.kin.common.log.LoggerFactory;
import jp.co.kin.db.entity.BaseEntity;

/**
 * DaoAspect
 *
 */
@Aspect
@Component
public class DaoAspect {

	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(DaoAspect.class);

	@Autowired
	@Qualifier("aesCrypter")
	private Crypter crypter;

	/**
	 * Dao実行時のAspect
	 * 
	 * @param pjp
	 *            ProceedingJoinPoint
	 * @return Service実行後のObject
	 * @throws Throwable
	 *             例外発生時、そのままthrow
	 */
	@Around("execution(* jp.co.kin.db.dao.*Dao.*(..))")
	public Object select(ProceedingJoinPoint pjp) throws Throwable {

		String daoName = pjp.getThis().getClass().getName();
		LOG.info(daoName + " called...");
		Object result = pjp.proceed();
		if (result instanceof BaseEntity) {

		}
		LOG.info(daoName + " success");

		return result;
	}
}
