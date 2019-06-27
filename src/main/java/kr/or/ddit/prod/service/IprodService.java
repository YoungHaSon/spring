package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.user.model.PageVo;

public interface IprodService {

	Map<String, Object> selectProdPagingList(Map<String, Object> map);
	
	Map<String, Object> prodPagingList(PageVo pageVo);
	
	/**
	* Method : lprodList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : lprodList받아오기
	*/
	List<LprodVo> lprodList();
	
}
