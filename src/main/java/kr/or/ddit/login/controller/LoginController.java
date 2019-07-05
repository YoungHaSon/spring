package kr.or.ddit.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@Controller
public class LoginController {

	@Resource(name = "userService")
	private IuserService userService;

	/**
	 * Method : loginView 
	 * 작성자 : PC13 
	 * 변경이력 :
	 * @param session
	 * @return 
	 * Method 설명 : 사용자 로그인 화면 요청
	 */
	// 전에 했던 jps login 부분!
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginView(HttpSession session) {
		if (session.getAttribute("USER_INFO") != null) {
			return "tiles.main";
		} else {
			return "login/login";
		}
	}

	// post
	/**
	 * Method : loginProcess 
	 * 작성자 : PC13 
	 * 변경이력 :
	 * @return 
	 * Method 설명 : 사용자 로그인 요청 처리
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST) // 인자로 주기만 하면 매개변수를 받은거다?
	public String loginProcess(String userId, String password, String rememberme, HttpServletResponse response, HttpSession session) {
		String encryptPassword = KISA_SHA256.encrypt(password);
		UserVo userVo = userService.getUser(userId);

		if (userVo != null && encryptPassword.equals(userVo.getPass())) {
			rememberMeCookie(userId, rememberme, response);
			
			session.setAttribute("USER_INFO", userVo);
			
			//forward
			return "main";
		}
		else
		return "login/login";
	}

	/**
	* Method : rememberMeCookie
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @param rememberme
	* @param response
	* Method 설명 : rememberMe 쿠키를 응답으로 생성
	*/
	private void rememberMeCookie(String userId, String rememberme, HttpServletResponse response) {
		int cookiesMaxAge = 0;
		if(rememberme != null) 
			cookiesMaxAge = 60*60*24*30;
			
		Cookie userIdCookie = new Cookie("userId", userId);
		userIdCookie.setMaxAge(cookiesMaxAge);
		
		Cookie rememberMeCookie = new Cookie("rememberme", "true");
		rememberMeCookie.setMaxAge(cookiesMaxAge);
		
		response.addCookie(userIdCookie);
		response.addCookie(rememberMeCookie);
	}
}
