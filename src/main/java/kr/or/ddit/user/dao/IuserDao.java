package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserDao {

	/**
	* Method : userList
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 전체 회원 리스트 받아오는!
	*/
	List<UserVo> userList();


	/**
	 * Method : getUser
	 * 작성자 : PC13
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 정보 조회
	 */
	UserVo getUser(String userId);
	
	/**
	* Method : userPagingList
	* 작성자 : PC13
	* 변경이력 :
	* @param pagevo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	List<UserVo> userPagingList(PageVo pageVo);
	
	/**
	* Method : usersCnt
	* 작성자 : PC13
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회 
	*/
	int usersCnt();
	
	/**
	 * Method : insertUser
	 * 작성자 : PC13
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	int insertUser(UserVo userVo);
	
	/**
	* Method : deleteUser
	* 작성자 : PC13
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	int deleteUser(String userId);
	
	/**
	* Method : updateUserInfo
	* 작성자 : PC13
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원정보 업데이트
	*/
	int updateUser(UserVo userVo);
	
	/**
	* Method : userListForPassEncrypt
	* 작성자 : PC13
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회
	*/
	List<UserVo> userListForPassEncrypt(SqlSession sqlSession);

	/**
	* Method : updateUserEncryptPass
	* 작성자 : PC13
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 적용
	*/
	int updateUserEncryptPass(SqlSession sqlSession, UserVo userVo);
	
	
	
	
	
	
}
	