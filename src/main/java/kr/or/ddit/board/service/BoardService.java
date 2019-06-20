package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.IboardDao;

@Service
public class BoardService implements IboardService {
	
	//필드명
	@Resource(name="boardDao")
	private IboardDao boradDao;
	
	private String name;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
