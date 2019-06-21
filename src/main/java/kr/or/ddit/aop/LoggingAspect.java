package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	public void before(JoinPoint joinPoint) {
		logger.debug("loggingAspect before method");
	}
	
	public void after(JoinPoint joinPoint) {
		logger.debug("loggingAspect after method");
	}
	
//	위에 before, after메서드를 합한것과 같다!
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//business logic 실행 전
		logger.debug("logging Aspect around method before");
		
		//business logic 실행 중
															//joinPoint를 이용하면 정보를 알아올수 있다?
		logger.debug("joinPoint.getSignature().getName() : {}", joinPoint.getSignature().getName());
		
		Object[] methodArgs = joinPoint.getArgs(); 
		Object returnObj = joinPoint.proceed(methodArgs); //proceed실행!
		//Object returnObj 반환값을 받아주는
		
		//business logic 실행 후
		logger.debug("logging Aspect around method after");
		
		return returnObj;
		
	}
	
}
