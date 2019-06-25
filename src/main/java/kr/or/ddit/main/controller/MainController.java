package kr.or.ddit.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.user.model.UserVo;

/*
	Servlet에서는 HTTPServlet을 상속(extends) 받아서 처리함
		Servlet-mapping(web.xml , @WebServlet)
		service --> doxxx 메서드가 실행
	
	Spring에서는 Pojo(Plain Old java Object) 상속 안 받아도댐!
		@RequestMapping을 활용함 --> class, method에 적용
		@RequestMapping에 설정한 url method를 호출!
*/

//1. 요 선언이 먼저!
@Controller
@SessionAttributes("rangers")
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	//UrlMapping이 되기 전에 model 객체?에 미리 담기는?
	
	//메서드에 적용된 @ModelAttribute는 @RequestMapping이 붙은 메서드가 실행될때(요청이 처리될때)
	//@ModelAttribute가 적용된 메서드가 리턴하는 값을 Model객체에 자동적으로 넣어준다.
	
	//localhost/main --> @RequestMapping("main") : mainView --> Model에는 Rangers 속성이 들어가 있다!?
	//localhost/mainMav --> @RequestMapping("mainMav") : mainViewMav --> Model에는 Rangers 속성이 들어가 있다!?
	
	@ModelAttribute("rangers")
	public List<String> rangers(){
		logger.debug("♬♪♩ rangers()에서 출력 중 ");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
		return rangers;
	}
	
	//main url로 요청이 오면 mainView() 메서드가 호출댐! //HttpServletRequest request 같은 역할
	
	/**
	* Method : mainView
	* 작성자 : PC13
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : viewName
	*/
	@RequestMapping("/main")
	public String mainView(Model model,@ModelAttribute("userVo") UserVo userVo){
		logger.debug("main입니다!");
		logger.debug("♬♪♩ model : {}", model.asMap().get("rangers"));
		logger.debug("♬♪♩ userVo : {}",userVo);

//		UserVo userVo = new UserVo();
//		userVo.setName("브라운");
//		model.addAttribute("userVo", userVo);
		userVo.setName("brown");
		//prefix: /WEB-INF-views/ 마지막에 / 있고 없고 차이 크데!
		//suffix: .jsp
		//prefix + viewName + suffix
		//실행해보면! ---> /WEB-INF-views/views/main.jsp
		
		// request.setAttribute("mainUserId", "brown"); 동일!
		model.addAttribute("mainUserId", "brown");
//		request.setAttribute("mainUserId", "brown");
		//viewName
		return "main";
	}
	
	/**
	* Method : mainViewMav
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : main page요청(modelAndView 사용)
	*/
	@RequestMapping("/mainMav")
	public ModelAndView mainViewMav(@ModelAttribute("rangers") List<String> rangers){
		
		logger.debug("main mainViewMav() 메서드 입니다!");
		logger.debug("♬♪♩ List<String> rangers : {}", rangers );
		
		//ViewName을 기반으로 ModelAndView 객체를 생성
		ModelAndView mav = new ModelAndView("main"); //--> ViewName!
		
		//위에 문장은 밑에 두 문장과 같다!!!!!
		//ModelAndView mav = new ModelAndView();
		//set.ViewName("main")
		mav.addObject("mainUserId", "brown");
		
		return mav;
	}
	
	/**
	* Method : pathVariable
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : pathVariable로 부터 사용자 아이디 가져오기 ( ex) 도서관?)
	*/
	
	//localhost/main/pathvariable/brown
	//localhost/main/pathvariable/sally
	@RequestMapping("/main/pathvariable/{userId}")
	public String pathVariable(@PathVariable("userId")String userId) {
		logger.debug("♬♪♩ @PathVariable(\"userId\")String userId : {}", userId );
		return "main";
	}
	
	/**
	* Method : header
	* 작성자 : PC13
	* 변경이력 :
	* @param accept
	* @return
	* Method 설명 : Accept Header 정보 가져오기!
	*/
	@RequestMapping("/main/header")
	public String header(@RequestHeader(name="Accept", required = false) String accept) {
		logger.debug("♬♪♩ Accept : {}", accept);
		return "main";
	}
	
}
