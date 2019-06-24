package kr.or.ddit.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	//main url로 요청이 오면 mainView() 메서드가 호출댐!
	@RequestMapping("/main")
	
//HttpServletRequest request 같은 역할
	public String mainView(Model model){
		logger.debug("main입니다!");
		
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
}
