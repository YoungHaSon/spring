package kr.or.ddit.file.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEvn;

public class FileControllerTest extends ControllerTestEvn{

	
	private static final Logger logger = LoggerFactory.getLogger(FileControllerTest.class);
	
	/**
	* Method : fileControllerTesttest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : uploadView 요청 테스트
	 * @throws Exception 
	*/
	@Test
	public void uploadViewTest() throws Exception {
		 /***Given***/
		

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/file/uploadView")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		/***Then***/
		logger.debug("♬♪♩ mvcResult : {}",mvcResult );
		logger.debug("♬♪♩ mav : {}",mav );
		logger.debug("♬♪♩ viewName : {}",viewName );
		
		assertEquals("upload/upload", viewName);
	}
	
	/**
	* Method : uploadTest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : 파일 업로드 테스트
	 * @throws Exception 
	*/
	@Test
	public void uploadTest() throws Exception {
		/***Given***/
		
		//방법 2개!
		File file = new File(getClass().getClassLoader().getResource("kr/or/ddit/testenv/sally.png").getFile());
		
		FileInputStream fis = new FileInputStream(file);
		//input에 있는 name, 실제 파일명, 안다면 입력 아니면 "" , 
		MockMultipartFile mockMultipartFile =  new MockMultipartFile("img", file.getName(), "", fis);		

		/***When***/
		MvcResult mvcResult = mockMvc.perform(fileUpload("/file/upload").file(mockMultipartFile)).andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String ViewName = mav.getViewName();
		String msg = (String) mav.getModelMap().get("msg");
	
		/***Then***/
		assertEquals("SUCCESS", msg);
		assertEquals("upload/upload", ViewName);
	}

}
