package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.PageVo;
@Repository
public class ProdDao implements IprodDao {

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ProdVo> selectProdPagingList(Map<String, Object> map) {
		return sqlSession.selectList("prod.selectProdPagingList", map);
	}

	@Override
	public int selectProdCnt(String prod_lgu) {
		return sqlSession.selectOne("prod.selectProdCnt",prod_lgu);
	}

	@Override
	public List<ProdVo> prodPagingList(PageVo pageVo) {
		return sqlSession.selectList("prod.prodPagingList", pageVo);
	}

	@Override
	public int prodCnt() {
		return sqlSession.selectOne("prod.prodCnt");
	}

	@Override
	public List<LprodVo> lprodList() {
		return sqlSession.selectList("prod.lprodList");
	}

	
	
}
