package kr.or.ddit.user.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//주입 완료! servlet에서의 init대신 주입!
	@Resource(name = "userService")
	private IuserService userService;
	
	/**
	* Method : userList
	* 작성자 : PC13
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : 사용자 전체 리스트
	*/
	//1. userListController 부분!
	@RequestMapping("/userList")
	public String userList(Model model) { //request객체 대신 model
		//userList라는 키 값에 userService.userList() 유저 리스트를 담아놓음!
		model.addAttribute("userList", userService.userList());
		return "user/userList";
	}
	
	/**
	* Method : userPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 페이징 리스트
	*/
	//2. userPagingList 부분 doget!
	@RequestMapping("/userPagingList") //매개 받기 , 기본값설정
//	public String userPagingList(@RequestParam(name = "page", defaultValue = "1")int page,
//									@RequestParam(name = "pageSize", defaultValue = "10")int pageSize, Model model) {
//		PageVo pageVo = new PageVo(page, pageSize);
	
	//pageVo의 기본값을 pageVo에서 getter에서 설정해주면된다!
	public String userPagingList(PageVo pageVo, Model model) {
		
		logger.debug("♬♪♩ pageVo : {}", pageVo );
			
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		model.addAttribute("userList", userList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);
		
		return "user/pagination";
	}
	
	
	
	


}