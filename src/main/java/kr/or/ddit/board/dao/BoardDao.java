package kr.or.ddit.board.dao;

import org.springframework.stereotype.Repository;

//Spring bean 이름 :  인스턴스 생성규칙 --> 클래스명에서 첫글자를 소문자로
//Spring bean 이름을 임의로 주고싶은 경우 @Repository("bDao")
@Repository
public class BoardDao implements IboardDao {

	@Override
	public String sayHello() {
		return "boardDao sayHello";
	}

}
