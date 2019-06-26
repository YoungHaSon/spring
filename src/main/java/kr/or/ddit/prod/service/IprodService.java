package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

public interface IprodService {

	public List<ProdVo> prodList(String lprod_gu);
}
