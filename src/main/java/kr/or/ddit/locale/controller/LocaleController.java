package kr.or.ddit.locale.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("locale")
@Controller
public class LocaleController {
	
	private static final Logger logger = LoggerFactory.getLogger(LocaleController.class);
	
	/**
	* Method : view
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : locale test를 위한 view 요청
	*/
	//localhost/locale/view
	
//	@RequestMapping("/view")
//	public String view(@RequestParam(name="lang", defaultValue="ko")String lang, Model model) {
//		logger.debug("♬♪♩ lang : {}",lang );
//		model.addAttribute("lang", lang);
//		return "tiles.locale";
//		
//	}
	@RequestMapping("/view")
	public String view(Locale locale, Model model) {
		logger.debug("♬♪♩ locale : {}",locale);
		
		logger.debug("♬♪♩ locale.getCountry() : {}",locale.getCountry());
		logger.debug("♬♪♩ locale.getDisplayCountry() : {}",locale.getISO3Country() );
		
		logger.debug("♬♪♩ locale.getLanguage() : {}",locale.getLanguage()); //ja
		logger.debug("♬♪♩ locale.getLanguage() : {}",locale.getISO3Language());
		
		model.addAttribute("lang", locale.getLanguage());
		return "tiles.locale";
		
	}
	
}
