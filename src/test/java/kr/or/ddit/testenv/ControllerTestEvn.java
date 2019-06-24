package kr.or.ddit.testenv;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
//설정한 것들을 가져오는
@ContextConfiguration({"classpath:kr/or/ddit/config/spring/application-context.xml",
						"classpath:kr/or/ddit/config/spring/root-context.xml",
						"classpath:kr/or/ddit/config/spring/application-datasource_dev.xml",
						"classpath:kr/or/ddit/config/spring/application-transaction.xml"})

//웹 환경에서의 테스트 

//		 일반 자바환경 --> 웹 환경
//applicationContext --> 웹 환경의 applicationContext생성
@WebAppConfiguration
public class ControllerTestEvn{
	//필요한것!
	//webAppicationContext 객체 --> Spring container
	//mockMvc --> dispatcher servlet역할
		
	@Autowired
	protected WebApplicationContext ctx; //Spring container
	protected MockMvc mockMvc; //dispatcher servlet역할
	
	@Before //(테스트 전 초기화!?)
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void test() {
		
	}
}
