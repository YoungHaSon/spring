package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.placeholder.DbInfo;

//스프링 컨테이너 구성? SpringJUnit4ClassRunner.class 쓰이는 모든 클래스가 컨테이너?
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-placeholder.xml")
public class SpringlifeCycleTest {
	
	@Resource(name = "dbinfo")
	private DbInfo dbInfo;

	@Test
	public void lifeCycleTest() {
		/*** Given ***/
		/*** When ***/

		/*** Then ***/
		assertNotNull(dbInfo.getDriver());
		assertNotNull(dbInfo.getUrl());
		assertNotNull(dbInfo.getUsername());
		assertNotNull(dbInfo.getPassword());
		
		assertEquals("oracle.jdbc.driver.OracleDriver", dbInfo.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbInfo.getUrl());
		assertEquals("pc13_test", dbInfo.getUsername());
		assertEquals("java", dbInfo.getPassword());

	}

}
