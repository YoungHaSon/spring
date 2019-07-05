package kr.or.ddit.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/aop/application-aop-scan.xml")
public class AopScanTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AopScanTest.class);
	
	@Resource(name="boardService")
	private IboardService BoardService;
	
	@Test
	public void aopTest() {
		/***Given***/
		

		/***When***/
		String msg = BoardService.sayHello();

		/***Then***/
		logger.debug("♬♪♩ msg : {}", msg);
		
//		assertEquals("boardDao sayHello", msg);
	}

}
