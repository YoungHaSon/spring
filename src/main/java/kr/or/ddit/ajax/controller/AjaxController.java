package kr.or.ddit.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@RequestMapping("/ajax")
@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Resource(name="userService")
	private IuserService userService;
	
	/**
	* Method : view
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : ajax 호출용 view
	*/
	@RequestMapping("/view")
	public String view() {
		
		return "tiles.ajaxView";
	}
	
	@RequestMapping("/requestData")
	public String requestData(Model model) {
		
		// org :{pageVo : {page : 5, pageSize:10}} 요런식으로 출력
		//data.pageVo.page로 접근해야함
		
		model.addAttribute("pageVo", new PageVo(5,10));
//		model.addAttribute("pageVo", new PageVo(2,10));
//		
//		List<String> rangers = new ArrayList<String>();
//		rangers.add("brown");
//		rangers.add("sally");
//		rangers.add("cony");
//		model.addAttribute("rangers", rangers);
		
		/*
		 *  {pageVo : {page : 5, pageSize : 10}}
		 *  {pageVo : {page : 5, pageSize : 10},{pageVo : {page : 2, pageSize : 10}}
		 *  {pageVo : {page : 5, pageSize : 10},{pageVo : {page : 2, pageSize : 10}, rangers:[sally]}}
		 */
		return "jsonView";
	}
	
	/**
	 * Method : requestDataResponseBody
	 * 작성자 : PC13
	 * 변경이력 :
	 * @param model
	 * @return
	 * Method 설명 : ajax! converter를 이용하여 jsonView를 거치지 않고 json을 받아 jsp에서 출력
	 */
	
	//@ResponseBody : {page : 5, pageSize:10}} 요런식으로 출력
	//data.page 로 접근해야함
	@RequestMapping("/requestDataResponseBody")
	@ResponseBody //--> 응답 내용을 responseBody에 작성을 해라!
	public PageVo requestDataResponseBody() {
		return new PageVo(5,10);
	}
	
	@RequestMapping("/user")
	public String user(String userId, Model model) {
		logger.debug("♬♪♩ userId : {}",userId );
		UserVo userVo =  userService.getUser(userId);
		
		logger.debug("♬♪♩ userVo : {}",userVo );
		model.addAttribute("userVo", userVo);
		
		//{userVo : userId:'brown', name='브라운', alias:'곰'}
		
		//context
		return "jsonView";
	}
	
	@RequestMapping("/userHtml")
	public String userHtml(String userId, Model model) {
		logger.debug("♬♪♩ userId : {}",userId );
		UserVo userVo =  userService.getUser(userId);
		
		logger.debug("♬♪♩ userVo : {}",userVo );
		model.addAttribute("userVo", userVo);
		
		return "user/userHtml";
	}
	// method = {RequestMethod.GET} get, post방식으로만 받겠다!           
	@RequestMapping(path="/requestBody"/*, method = {RequestMethod.POST} */
			, consumes = {"application/json"}, //contentType이 json일때만 요청을 받겠따!
				produces= {"application/json","application/xml"})// 메서드가 생성 가능한 타입!
	@ResponseBody
	public UserVo requestBody(@RequestBody UserVo userVo) {
		logger.debug("♬♪♩ userVo : {}", userVo);
		userVo.setUserId(userVo.getUserId() +"_MODIFY");
		userVo.setPass(userVo.getPass() +"_MODIFY");
		
		return userVo;
	}
	
	
	
}
