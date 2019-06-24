package kr.or.ddit.aop;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.service.IboardService;
import kr.or.ddit.testenv.LogicTestEvn;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/aop/application-aop-scan.xml")
public class AopScanTest extends LogicTestEvn {

	@Resource(name="boardService")
	private IboardService BoardService;
	
	@Test
	public void aopTest() {
		/***Given***/
		

		/***When***/
		String msg = BoardService.sayHello();

		/***Then***/
		assertEquals("boardDao sayHello", msg);
	}

}
