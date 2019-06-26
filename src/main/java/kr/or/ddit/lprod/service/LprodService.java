package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.user.model.PageVo;

@Service
public class LprodService implements IlprodService {

	@Resource(name = "lprodDao")
	private IlprodDao lprodDao;
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Map<String, Object> LprodPagination(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList", lprodDao.lprodPagingList(pageVo));
		
		int lprodCnt = lprodDao.lprodCnt();
		int paginationSize = (int)Math.ceil((double)lprodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
		
	}
	

}
