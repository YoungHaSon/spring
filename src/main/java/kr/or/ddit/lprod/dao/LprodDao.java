package kr.or.ddit.lprod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.user.model.PageVo;


@Repository
public class LprodDao implements IlprodDao {

	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	/**
	* Method : lprodPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @param lprodVo
	* @return
	* Method 설명 : lprod 페이징 리스트 조회
	*/
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		return sqlSession.selectList("lprod.lprodPagingList", pageVo);
	}

	/**
	* Method : lprodCnt
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 수 조회
	*/
	@Override
	public int lprodCnt() {
		return (Integer) sqlSession.selectOne("lprod.lprodCnt");
	}



}
