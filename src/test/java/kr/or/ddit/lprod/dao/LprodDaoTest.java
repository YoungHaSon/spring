package kr.or.ddit.lprod.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.testenv.LogicTestEvn;
import kr.or.ddit.user.model.PageVo;

public class LprodDaoTest extends LogicTestEvn{

	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	@Resource(name="lprodDao")
	private IlprodDao lprodDao;
	
	@Test
	public void lprodPagingList() {
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		List<LprodVo> lprodList = lprodDao.lprodPagingList(pageVo);
		logger.debug("♬♪♩ lprodList : {}", lprodList);
		
		/***Then***/
		assertNotNull(lprodList);
		logger.debug("♬♪♩ lprodList.size() : {}", lprodList.size() );
	}
	
	@Test
	public void lprodCnt() {
		/***Given***/

		/***When***/
		int num = lprodDao.lprodCnt();

		/***Then***/
		logger.debug("♬♪♩ num : {}",num );
		assertEquals(13, num);
	}
	
}
