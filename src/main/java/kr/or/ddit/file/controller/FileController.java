package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.util.PartUtil;

@RequestMapping("/file")
@Controller
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	/**
	* Method : uploadView
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 :	file upload를 할수 있는 테스트 view 리턴 -->jsp로 !
	*/
	@RequestMapping("/uploadView")
	public String uploadView() {
		logger.debug("♬♪♩ uploadView() 입니다.");
		return "upload/upload"; //jsp로 !
	}
	
	/**
	* Method : upload
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 전송을 누르면 해당 사진을 처리!! --jsp에서 받아온 정보 처리!
	*/
	@RequestMapping("/upload")
	public String upload(@RequestPart("img") MultipartFile file, Model model) {
		// @RequestPart("img") input의 name이 img인 걸 가져와라!!
		logger.debug("♬♪♩ Filename() : {}",file.getOriginalFilename());
		logger.debug("♬♪♩ file.getName() : {}",file.getName());
		logger.debug("♬♪♩ file.getSize() : {}",file.getSize());
		
		//	d:\springUpload\2019\06
		String path = PartUtil.getUploadPath();
		String ext = PartUtil.getExt(file.getOriginalFilename());
		String fileName = UUID.randomUUID().toString();
		logger.debug("♬♪♩ path : {}",path );
		logger.debug("♬♪♩ ext : {}",ext );
		logger.debug("♬♪♩ fileName : {}", fileName);
		
							//파일이 업로드될 경로!! File.separator--> / 달랑 하나!
		File uploadFile = new File(path + File.separator + fileName + ext);
		
		try {
			//해당 파일 지정된 경로에 업로드...
			file.transferTo(uploadFile); 
			model.addAttribute("msg", "SUCCESS");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			model.addAttribute("msg", "FAIL");
		}
		//다시 jsp 호출!
		return "upload/upload";
	}
	
}
