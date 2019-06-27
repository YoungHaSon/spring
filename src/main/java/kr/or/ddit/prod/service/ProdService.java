package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.prod.dao.IprodDao;
import kr.or.ddit.user.model.PageVo;

@Service
public class ProdService implements IprodService {
	
	@Resource(name = "prodDao")
	private IprodDao prodDao;

	@Override
	public Map<String, Object> selectProdPagingList(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("selectprodList", prodDao.selectProdPagingList(map));
		
		int selectProdCnt = prodDao.selectProdCnt((String)map.get("prod_lgu"));
		int paginationSize = (int)Math.ceil((double)selectProdCnt/(Integer)map.get("pageSize"));
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public Map<String, Object> prodPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prodPagingList", prodDao.prodPagingList(pageVo));
		
		int prodCnt = prodDao.prodCnt();
		int paginationSize = (int)Math.ceil((double)prodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public List<LprodVo> lprodList() {
		return prodDao.lprodList();
	}
	
	
}
