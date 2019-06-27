package kr.or.ddit.exception.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.exception.NoFileException;

@Controller
public class ExceptionController {

	//예외 발생
	@RequestMapping("/exception")
	public String exception() {
		throw new ArithmeticException();
	}
	
	@RequestMapping("/ioException")
	public String ioException() throws IOException {
		ClassPathResource cpr = new ClassPathResource("kr/or/ddit/config/mybatis/mybatis-config-not_exist.xml");
		cpr.getInputStream();
		return "main";
	}
	
	@RequestMapping("/nofileException")
	public String nofileException() throws NoFileException{
		try {
			ClassPathResource cpr = new ClassPathResource("kr/or/ddit/config/mybatis/mybatis-config-not_exist.xml");
			cpr.getInputStream();
		} catch (Exception e) {
			//발생한 예외를 개발자가 개발한 새로운 예외로 던진다.
			throw new NoFileException();
		}
		return "main";
	}
	
	
	
}
