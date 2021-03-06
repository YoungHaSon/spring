package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

@Repository
public class UserDao implements IuserDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;

	//커밋 불가...!
	/**
	* Method : userList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 전체 회원 리스트 받아오는!
	*/
	@Override
	public List<UserVo> userList() {
		return sqlSession.selectList("user.userList");
	}

	/**
	* Method : insertUser
	* 작성자 : PC13
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		return sqlSession.insert("user.insertUser",userVo);
	}
	
	/**
	* Method : deleteUser
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		return sqlSession.delete("user.deleteUser",userId);
		
	}
	
	/**
	* Method : getUser
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	@Override
	public UserVo getUser(String userId) {
		return sqlSession.selectOne("user.getUser",userId);
	}

	@Override
	public List<UserVo> userPagingList(PageVo pageVo) {
		return sqlSession.selectList("user.userPagingList", pageVo);
	}

	@Override
	public int usersCnt() {
		return (Integer) sqlSession.selectOne("user.usersCnt");
	}

	@Override
	public int updateUser(UserVo userVo) {
		return (Integer) sqlSession.update("user.updateUser", userVo);
	}

	@Override
	public List<UserVo> userListForPassEncrypt(SqlSession sqlSession) {
		return sqlSession.selectList("user.userListForPassEncrypt");
	}

	@Override
	public int updateUserEncryptPass(SqlSession sqlSession, UserVo userVo) {
		return sqlSession.update("user.updateUserEncryptPass",userVo);
	}
	
}
