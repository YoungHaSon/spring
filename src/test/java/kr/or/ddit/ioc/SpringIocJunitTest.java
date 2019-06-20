package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
//설정 파일 위치 설정
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-test.xml")
public class SpringIocJunitTest {
//DI개념
	
	
	//field 기준 boardService, boardService2 : Spring boardService bean (기존적으로 scope=singleton)
	//				boardServiceConstructor : Spring boardServiceconstructor bean (기존적으로 scope=singleton)
	//1. boardService, boardSerive2 : 같아야함
	//2. boardService, boardServiceConstructor : 같은 클래스에서 만들어진 객체이지만 Spring singleton 개념에 따라 다른 객체
	//2. boardService2, boardServiceConstructor : 같은 클래스에서 만들어진 객체이지만 Spring singleton 개념에 따라 다른 객체
	@Resource(name="boardService")
	private IboardService boardService;
	
	@Resource(name="boardService")
	private IboardService boardService2;
	//아래랑 같은뜻
	
//	//스프링 컨테이너 생성
//	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-ioc-test.xml");
//	IboardService boardService = (IboardService)context.getBean("boardService");
	
	@Resource(name="boardServiceConstructor")
	private IboardService boardServiceConstructor;
	
	//boardDao : spring boardDao(Scope=singleton)
	//boardDaoprototype : spring boardDaoprototype(Scope=prototype)
	//boardDaoprototype : spring boardDaoprototype2(Scope=prototype)
	
	//1. boardDao boardDaoPrototype : spring bean id가 다르므로 다른 객체
	//2. boardDaoPrototype, boardDaoPrototype2 : 두객체는 같은 스피링 빈이지만 scope가 prototype이므로 다른 객체 여야 한다.
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	@Resource(name="boardDaoPrototype")
	private IboardDao boardDaoPrototype;
	
	@Resource(name="boardDaoPrototype")
	private IboardDao boardDaoPrototype2;
	
	
	@Test 
	public void boardDaoprototypeTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotEquals(boardDao, boardDaoPrototype);
		assertNotEquals(boardDaoPrototype, boardDaoPrototype2);
	}
	
	/**
	* Method : SpringIocTest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : 스프링 컨테이너 생성 테스트
	*/
	@Test
	public void springIocTest() {
		/***Given***/
		
		/***When***/
		String msg = boardService.sayHello();
		
		/***Then***/
		assertNotNull(boardService);
		assertEquals("boardDao sayHello", msg);
	}
	
	@Test
	public void singletonTest() {
		/***Given***/
		
		/***When***/
	
		/***Then***/
		assertEquals(boardService, boardService2);
		assertNotEquals(boardService, boardServiceConstructor);
		assertNotEquals(boardService2, boardServiceConstructor);
	}

}
