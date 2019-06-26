package kr.or.ddit.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.IprodDao;
import kr.or.ddit.prod.model.ProdVo;

@Service
public class ProdService implements IprodService {
	
	@Resource(name = "prodDao")
	private IprodDao prodDao;
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ProdVo> prodList(String prod_lgu) {
		return prodDao.prodList(prod_lgu);
	}
}
