package kr.or.ddit.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//mainController가 잘되는지 Test

@RunWith(SpringJUnit4ClassRunner.class)
//설정한 것들을 가져오는
@ContextConfiguration({"classpath:kr/or/ddit/config/spring/application-context.xml",
						"classpath:kr/or/ddit/config/spring/root-context.xml",
						"classpath:kr/or/ddit/config/spring/application-datasource_dev.xml",
						"classpath:kr/or/ddit/config/spring/application-transaction.xml"})

// 웹 환경에서의 테스트 

//		 일반 자바환경 --> 웹 환경
//applicationContext --> 웹 환경의 applicationContext생성
@WebAppConfiguration
public class MainControllerTest2 {

	private static final Logger logger = LoggerFactory.getLogger(MainControllerTest2.class);
	
	//필요한것!
	//webAppicationContext 객체 --> Spring container
	//mockMvc --> dispatcher servlet역할
	
	@Autowired
	private WebApplicationContext ctx; //Spring container
	private MockMvc mockMvc; //dispatcher servlet역할
	
	@Before //(테스트 전 초기화!?)
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/**
	* Method : mainViewTest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : mainView 호출 테스트
	 * @throws Exception 
	*/
	@Test
	public void mainViewAndExpectTest() throws Exception {
		mockMvc.perform(get("/main")).andExpect(status().isOk())
									.andExpect(view().name("main"))
									.andExpect(model().attribute("mainUserId", "brown" ));
		
	}
}
