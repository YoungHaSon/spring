package kr.or.ddit.lprod.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.testenv.LogicTestEvn;
import kr.or.ddit.user.model.PageVo;

public class LprodServiceTest extends LogicTestEvn{

	private static final Logger logger = LoggerFactory.getLogger(LprodServiceTest.class);
	
	@Resource(name="lprodService")
	private IlprodService lprodService;
	
	@Test
	public void lproduPagingList() {
		/***Given***/
		PageVo pageVo = new PageVo(1,10);
		
		/***When***/
		Map<String, Object> resultMap = (Map<String, Object>) lprodService.LprodPagination(pageVo);
		List<LprodVo> lprodList =  (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		/***Then***/
		//PagingList assert
		logger.debug("♬♪♩ lprodList : {}",lprodList );
		logger.debug("♬♪♩ lprodList.size() : {}",lprodList.size() );
		logger.debug("♬♪♩ paginationSize : {}",paginationSize );
		
		assertNotNull(lprodList);
		assertEquals(10, lprodList.size());
		assertEquals(2, paginationSize);
	}
	
}
