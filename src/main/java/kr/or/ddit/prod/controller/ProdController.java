package kr.or.ddit.prod.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.IprodService;
import kr.or.ddit.user.model.PageVo;

@SessionAttributes("lprodList")
@RequestMapping("/prod")
@Controller
public class ProdController {
	
	@Resource(name="prodService")
	private IprodService prodService;
	
	@ModelAttribute("lprodList")
	public List<LprodVo> lprodList(){
		return prodService.lprodList();
	}
	
	@RequestMapping("/prodpagination")
	public String prodpagination(PageVo pageVo, Model model) {
		Map<String, Object> resultMap = prodService.prodPagingList(pageVo);
		
		List<ProdVo> prodList = (List<ProdVo>) resultMap.get("prodPagingList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		model.addAttribute("prodList", prodList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);
		
		return "prod/prodPagination";
	}
	

	
	

}
