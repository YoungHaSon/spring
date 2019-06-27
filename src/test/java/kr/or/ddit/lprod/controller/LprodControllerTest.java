package kr.or.ddit.lprod.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.testenv.ControllerTestEvn;

public class LprodControllerTest extends ControllerTestEvn {

	private static final Logger logger = LoggerFactory.getLogger(LprodControllerTest.class);
	
	@Test
	public void lprodPagingList() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/lprod/lprodpagination")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		logger.debug("♬♪♩ mav.getViewName() : {}",mav.getViewName() );
		assertEquals("lprod/lprodPagination", mav.getViewName());
		logger.debug("♬♪♩ lprodList.Size: {}", ((List<LprodVo>) mav.getModelMap().get("lprodList")).size());
		assertEquals(10, ((List<LprodVo>) mav.getModelMap().get("lprodList")).size());
		logger.debug("♬♪♩ mav.getModelMap().get(\"lprodList\") : {}", mav.getModelMap().get("lprodList") );
	}
	
}
