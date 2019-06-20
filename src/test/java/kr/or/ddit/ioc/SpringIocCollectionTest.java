package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.collection.IocCollection;

//스프링 컨테이너 구성? SpringJUnit4ClassRunner.class 쓰이는 모든 클래스가 컨테이너?
@RunWith(SpringJUnit4ClassRunner.class)
//
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-Ioc-collection.xml")
public class SpringIocCollectionTest {
	 
	@Resource(name="collectionBean")
	private IocCollection iocCollection;
	
	@Test
	public void springIocCollectionTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertEquals("brown", iocCollection.getList().get(0));
		assertEquals("sally", iocCollection.getList().get(1));
		assertEquals("cony", iocCollection.getList().get(2));
		
		assertEquals("brown", iocCollection.getMap().get("name"));
		assertEquals("2019-08-08", iocCollection.getMap().get("birth"));

//		set --> 담고 있냐 없냐
		assertTrue(iocCollection.getSet().contains("brown"));
		assertTrue(iocCollection.getSet().contains("sally"));
		assertTrue(iocCollection.getSet().contains("cony"));

		assertEquals("brown", iocCollection.getProperties().get("userId"));
		assertEquals("브라운", iocCollection.getProperties().get("name"));
	
	}

}
