package kr.or.ddit.aop;

import java.text.SimpleDateFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class profilingAspect {

	private static final Logger logger = LoggerFactory.getLogger(profilingAspect.class);

	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {}
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");

	//dummy()메서드를 기준으로 실행해라!
	@Around("dummy()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long time1 = System.currentTimeMillis();
		logger.debug("profilingAspect before method time :{}", sdf.format(time1));

		// business logic 실행 중
		// joinPoint를 이용하면 정보를 알아올수 있다?
		logger.debug("joinPoint.getSignature().getName() : {}", joinPoint.getSignature().getName());

		Object[] methodArgs = joinPoint.getArgs();
		Object returnObj = joinPoint.proceed(methodArgs); // proceed실행!
		// Object returnObj 반환값을 받아주는

		// business logic 실행 후
		long time2 = System.currentTimeMillis();
		logger.debug("profilingAspect after method time :{}", sdf.format(time2));

		long time3 = time2 - time1;
		logger.debug(returnObj + "method 실행시간 : {}", time3);

		return returnObj;

	}

}
