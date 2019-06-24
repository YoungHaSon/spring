package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;
import kr.or.ddit.testenv.LogicTestEvn;

//스프링 컨테이너 구성? SpringJUnit4ClassRunner.class 쓰이는 모든 클래스가 컨테이너?
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-st.xml")
public class SpringIocStTest extends LogicTestEvn{
	
	@Resource(name="bDao")
	private IboardDao boardDao;

	@Resource(name="bService")
	private IboardService boardService;
	
	@Test
	public void springIocStTest2() {
		/***Given***/
		
		/***When***/
				
		
		/***Then***/
		assertEquals(boardDao, boardService.getBoradDao());
		
	}

}
