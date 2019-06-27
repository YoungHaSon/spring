package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//사용하려면 web.xml에도 등록해줘야함
public class PerfomanceInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(PerfomanceInterceptor.class);
	
	//controller가기전에 실행되는 부분!
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//true를 리턴하면 다음 인터셉터 혹은 인터셉터가 없을경우 controller로 요청이감!
		//false를 리턴하면 요청이 중단댐!
		logger.debug("♬♪♩ preHandle : {}", request.getRequestURI());
		
		request.setAttribute("start", System.currentTimeMillis());
		
		return true;
	}

	//controller 메서드가 실행된 후 여기로 옴! 그래서 리턴 타입이 읎고 void임
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		long start = (Long)request.getAttribute("start");
		long end = System.currentTimeMillis();
		logger.debug("♬♪♩ end-start : {}", end - start + " 초!");
		
		logger.debug("♬♪♩ postHandle : {}", request.getRequestURI());
	}

	
	
}
