package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.PageVo;

public interface IprodDao {
	
	/**
	* Method : lprodPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @param lprodVo
	* @return
	* Method 설명 : 특정 prod 페이징 리스트 조회
	*/
	List<ProdVo> selectProdPagingList(Map<String, Object> map);
	
	/**
	* Method : lprodCnt
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 특정 prod 전체 수 조회
	*/
	int selectProdCnt(String prod_lgu);
	
	/**
	* Method : lprodPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @param lprodVo
	* @return
	* Method 설명 :prod 페이징 리스트 조회
	*/
	List<ProdVo> prodPagingList(PageVo pageVo);
	
	/**
	* Method : lprodCnt
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 :prod 전체 수 조회
	*/
	int prodCnt();
	
	/**
	* Method : lprodList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : lprodList받아오기
	*/
	List<LprodVo> lprodList();
	
	
	

	
}
