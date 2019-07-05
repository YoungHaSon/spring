package kr.or.ddit.prod.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.IprodService;
import kr.or.ddit.user.model.PageVo;

@SessionAttributes("lprodList")
@RequestMapping("/prod")
@Controller
public class ProdController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdController.class);
	
	@Resource(name="prodService")
	private IprodService prodService;
	
	@ModelAttribute("lprodList")
	public List<LprodVo> lprodList(){
		return prodService.lprodList();
	}
	
	@RequestMapping(path = "/prodpagination", method = RequestMethod.GET)
	public String prodpaginationGet(PageVo pageVo, Model model) {
		logger.debug("♬♪♩ prodPagination");
		
		Map<String, Object> resultMap = prodService.prodPagingList(pageVo);
		
		List<ProdVo> prodList = (List<ProdVo>) resultMap.get("prodPagingList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		model.addAttribute("prodList", prodList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);
		
		return "prod/prodPagination";
	}
	
	@RequestMapping(path = "/prodPagination", method = RequestMethod.POST)
	public String prodpaginationPost(String prod_lgu, Model model,PageVo pageVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.debug("♬♪♩ prod_lgu : {}",prod_lgu );
		
		map.put("page", pageVo.getPage());
		map.put("pageSize", pageVo.getPageSize());
		map.put("prod_lgu", prod_lgu);
		Map<String, Object> resultMap = prodService.selectProdPagingList(map);
		
		List<ProdVo> prodList = (List<ProdVo>) resultMap.get("selectprodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		model.addAttribute("prodList", prodList);
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("prod_lgu", prod_lgu);
		
		return "prod/prodPagination";
	}
	

	
	

}
