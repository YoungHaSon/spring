package kr.or.ddit.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.user.dao.IuserDao;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionCheckInterceptor.class);
	
	@Resource(name = "userDao")
	private IuserDao userDao;
	
	//controller 가기전에 실행
	/**
	* Method : preHandle
	* 작성자 : PC13
	* 변경이력 :
	* @param request
	* @param response
	* @param handler
	* @return
	* @throws Exception
	* Method 설명 : 로그인한 사용자만 controller에 접근이 가능하도록 체크
	*/
	//컨트롤러가 호출되기 전에 실행되는 메서드이다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		//사용자 로그인 상태 확인
		if(session.getAttribute("USER_INFO") != null) {
			return true; 
		
		//로그인 상태가 아닌경우 --> 로그인 페이지로 이동
		}else {
			
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		
	}

	//컨트롤러가 호출되고 난 후에 실행되는 메서드이다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("♬♪♩ userDao : {}",userDao );
		request.setAttribute("userList", userDao.userList());
	}

	
}
