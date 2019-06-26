package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.user.model.PageVo;


public interface IlprodDao {

	
	/**
	* Method : lprodPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @param lprodVo
	* @return
	* Method 설명 : lprod 페이징 리스트 조회
	*/
	List<LprodVo> lprodPagingList(PageVo pageVo);
	
	
	/**
	* Method : lprodCnt
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 수 조회
	*/
	int lprodCnt();
	
}
