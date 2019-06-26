package kr.or.ddit.lprod.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.user.model.PageVo;

	

@RequestMapping("/lprod")
@Controller
public class LprodController {

	private static final Logger logger = LoggerFactory.getLogger(LprodController.class);
	
	@Resource(name="lprodService")
	private IlprodService lprodService;
	
	@RequestMapping("/lprodpagination")
	public String lprodpagination(PageVo pageVo, Model model) {
		
		logger.debug("♬♪♩ pageVo : {}", pageVo );
		
		Map<String, Object> resultMap = lprodService.LprodPagination(pageVo);
		
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		model.addAttribute("lprodList", lprodList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);
		
		return "lprod/lprodPagination";
		
	}
}
