package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.BoardService;

@Configuration
public class ApplicationIocConfig {

//	<bean id="boardDao" class="kr.or.ddit.board.dao.BoardDao"></bean>
// 위의 주석이랑 같은 뜻..!
	
	@Bean
	public IboardDao boardDao() {
		return new BoardDao();
	}
//	<bean id="boardService" class="kr.or.ddit.board.service.BoardService" >
//	<!-- boardService의 field, property -->
//	<!-- setter injection(주입) -->
//	<property name="boradDao" ref="boardDao"></property>
// 	</bean>

	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardService();
		boardService.setName("brown");
		boardService.setBoradDao(boardDao());
		return boardService;
	}


	
}
