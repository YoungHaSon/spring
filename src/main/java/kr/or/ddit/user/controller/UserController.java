package kr.or.ddit.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.util.PartUtil;

@RequestMapping("/user")
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
	@RequestMapping("/list")
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
	@RequestMapping("/pagingList") //매개 받기 , 기본값설정
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
	
	/**
	* Method : user
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @param model
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	@RequestMapping("/user")
	public String user(String userId, Model model){
		
		model.addAttribute("userVo", userService.getUser(userId));
		
		return "user/user";
	}
	
	/**
	* Method : userForm
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 등록 화면 get방식
	*/
	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public String userForm() {
		return "user/userForm";
	}
	
	/**
	* Method : userForm
	* 작성자 : PC13
	* 변경이력 :
	* @param userVo
	* @param userId
	* @param profile
	* @param model
	* @return
	* Method 설명 : 사용자 등록 화면 post방식
	 * @throws IOException 
	 * @throws IllegalStateException 
	*/
	@RequestMapping(path = "/form", method = RequestMethod.POST) //name 속성명!
	public String userForm(UserVo userVo, String userId, String pass, MultipartFile profile, Model model) throws IllegalStateException, IOException{
		logger.debug("♬♪♩ userForm profile ");
		
		String viewName = "";
		UserVo dbUser = userService.getUser(userId);
		
		if(dbUser == null) {
			if(profile.getSize() > 0) {
				profileUpload(userVo, profile);
			}
			userVo.setPass(KISA_SHA256.encrypt(pass));
			int insertCnt = userService.insertUser(userVo);
			
			if(insertCnt == 1) {
				viewName = "redirect:/user/pagingList";
			}
			
		}else { 
				model.addAttribute("msg", "이미 존재하는 사용자입니다.");
				viewName = userForm();
		}
		return viewName;
	}

	
	
	/**
	* Method : profile
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @param request
	* @param response
	* @throws IOException
	* Method 설명 : 사용자 사진 응답 생성
	*/
	@RequestMapping("/profile")
	public void profile(String userId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//사용자 정보(Path)를 조회
			UserVo userVo = userService.getUser(userId);
			//path 정보로 file을 읽어서 
			ServletOutputStream sos = response.getOutputStream();
			FileInputStream fis = null;
			String filePath = userVo.getPath();
			
			//실제로 해당 파일이있는지 없는지 체크..!
			if(filePath == null){
				filePath =  request.getServletContext().getRealPath("/img/사진없음.jpg");
		      } else {
		         File checkFile = new File(filePath);
		         
		         if(!checkFile.exists()) {
		        	 filePath =  request.getServletContext().getRealPath("/img/사진없음.jpg");
		         }
		      }
			//화면에 띄워주는 부분!
			File file = new File(filePath);
			fis = new FileInputStream(file);
			byte[] buffer = new byte[512];
			
			//다읽으면 -1 반환, 	
			//response 객체에 스트림으로 ? 써준다?
			while(fis.read(buffer, 0, 512) != -1){
				sos.write(buffer);
			}
			fis.close();
			sos.close();
	}
	
	/**
	* Method : userModify
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @param model
	* @return
	* Method 설명 : 사용자 정보 수정화면 요청!
	*/
	@RequestMapping(path = "/modify", method = RequestMethod.GET)
	public String userModify(String userId, Model model){
		
		model.addAttribute("userVo", userService.getUser(userId));
		return "user/userModify";
	}
	
	/**
	* Method : userModify
	* 작성자 : PC13
	* 변경이력 :
	* @param userVo
	* @param userId
	* @param pass
	* @param file
	* @param model
	* @return
	* Method 설명 : 사용자 정보 수정!
	 * @throws IOException 
	 * @throws IllegalStateException 
	*/
	@RequestMapping(path = "/modify", method = RequestMethod.POST) //name 속성명!
	public String userModify(UserVo userVo, String userId, MultipartFile profile,
			HttpSession session, Model model, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException{
//		userVo.setPass(KISA_SHA256.encrypt(userVo.getPass()));

		//사용자가 사진올렸을때!
		if(profile.getSize() > 0) {
			profileUpload(userVo, profile);
		}
		int updateCnt = userService.updateUser(userVo);
		
		if(updateCnt == 1) {
			redirectAttributes.addFlashAttribute("msg", "등록되었습니다.");
			
			//return "redirect:/user/user?userId=" + userVo.getUserId() 요거랑 같은뜻
			redirectAttributes.addAttribute("userId", userVo.getUserId()); //리다이렉트 페이지 파라미터 전달
			return "redirect:/user/user";
		}
		else{
			return userModify(userVo.getUserId(), model);
		}
	}
	
	/**
	* Method : profileUpload
	* 작성자 : PC13
	* 변경이력 :
	* @param userVo
	* @param profile
	* @throws IOException
	* Method 설명 : Upload메서드
	*/
	private void profileUpload(UserVo userVo, MultipartFile profile) throws IOException {
		String filename = profile.getOriginalFilename();
		//파일이름을 넘겨서  확장자 얻어오기!
		String ext = PartUtil.getExt(filename);
		
		String uploadPath = PartUtil.getUploadPath();
		//디스크에 쓰기
		String filePath = uploadPath + File.pathSeparator + UUID.randomUUID().toString() + ext;
		
		userVo.setPath(filePath);
		userVo.setFilename(filename);
		
		profile.transferTo(new File(filePath));
	}
}
