package kr.or.ddit.main.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEvn;

//mainController가 잘되는지 Test

public class MainControllerTest extends ControllerTestEvn{

	private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class);
	
	
	/**
	* Method : mainViewTest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : mainView 호출 테스트
	 * @throws Exception 
	*/
	@Test
	public void mainViewTest() throws Exception {
		/***Given***/
		
		/***When***/
//		mockMvc.perform(MockMvcRequestBuilders.get("main"));
		MvcResult mvcResult = mockMvc.perform(get("/main")).andReturn();
		
		// model과 view를 합쳐놓은 타입
		ModelAndView mav = mvcResult.getModelAndView();
		
		//설정한 viewName을 알수있다!
		String viewName = mav.getViewName();
		
		String userId = (String) mav.getModel().get("mainUserId");

		/***Then***/
		assertEquals("brown", userId);
		assertEquals("main", viewName);
		logger.debug("↖↙ ---------------------------------------------------------- ↘↗");
		logger.debug("userId : {}" , userId);
		logger.debug("viewName : {}" , viewName);
		logger.debug("↙↖ ---------------------------------------------------------- ↗↘");

	}

}
