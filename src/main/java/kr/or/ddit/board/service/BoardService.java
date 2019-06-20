package kr.or.ddit.board.service;

import kr.or.ddit.board.dao.IboardDao;

public class BoardService implements IboardService {
	
	//필드명
	private IboardDao boradDao;
	
	//기본 생성자
	public BoardService() {
	}
	
	public BoardService(IboardDao boradDao) {
		this.boradDao = boradDao;
	}

	@Override
	public String sayHello() {
		return boradDao.sayHello();
	}

	public IboardDao getBoradDao() {
		return boradDao;
	}

	public void setBoradDao(IboardDao boradDao) {
		this.boradDao = boradDao;
	}

}
