package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
//xml 파일을 스캔해서 bean 등록
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-bean-scan.xml")
public class SpringIocBeanScanTest {

	//<bean> 태그를 이용하여 스프링 빈을 등록하는 방식을 사용하지 않고
	//@Controller, @Service(Service), @Respository(Dao) 
	//어노테이션을 적용한 클래스를 base package 하위 모든 클래스를 scan 하여 
	//스프링 빈으로 등록
	
	//boardDao, boardService 스프링 빈이 정상적으로 생성 되었는지
	
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	@Resource(name="boardService")
	private IboardService boardService;
	
	@Test
	public void springIocBeanScanTest() {
		/***Given***/
		

		/***When***/
		String msg = boardDao.sayHello();
		
		/***Then***/
		assertNotNull(boardDao);
		assertEquals("boardDao sayHello", msg);
		assertEquals(boardDao, boardService.getBoradDao());
		
		
	}

}
