package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;

@Repository
public class UserDao implements IuserDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;

	//커밋 불가...!
	@Override
	public List<UserVo> userList() {
		return sqlSession.selectList("user.userList");
	}

	@Override
	public int insertUser(UserVo userVo) {
		return sqlSession.insert("user.insertUser",userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return sqlSession.delete("user.deleteUser",userId);
		
	}
	
}
