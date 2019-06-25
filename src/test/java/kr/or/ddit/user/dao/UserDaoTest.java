package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.testenv.LogicTestEvn;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends LogicTestEvn {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Resource(name = "userDao")
	private IuserDao UserDao;

	/**
	* Method : userListTest
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : 전체 사용자 조회 테스트
	*/
	@Test
	public void userListTest() {
		/*** Given ***/

		/*** When ***/
		List<UserVo> userList = UserDao.userList();

		/*** Then ***/
		assertNotNull(userList);
		assertTrue(userList.size() >= 100);
	}

	/**
	* Method : insertUserTest
	* 작성자 : PC13
	* 변경이력 :
	* @throws ParseException
	* Method 설명 : 사용자 등록, 삭제 테스트
	*/
	@Test
	public void insertUserTest() throws ParseException {
		/*** Given ***/
		// 사용자 정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserVo userVo = new UserVo("cherry", "대덕인", "중앙로", "userTest1234", "대전광역시 중구 중앙로76", "영민빌딩 204호", "34940",
				sdf.parse("2019-05-31"));

		/*** When ***/
		// userDao.insertUser()
		int insertCnt = UserDao.insertUser(userVo);

		/*** Then ***/
		assertEquals(1, insertCnt);

		// data 삭제
		int deleteUser = UserDao.deleteUser(userVo.getUserId());
		assertEquals(1, deleteUser);
	}
	
	/**
	* Method : getUser
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	@Test
	public void getUser() {
		/***Given***/
		String userId = "brown";

		/***When***/

		UserVo userVo = UserDao.getUser(userId);
		/***Then***/
		assertEquals("브라움", userVo.getName());
	}
	
	/**
	* Method : userPagingList
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : pagenationTest
	*/
	@Test
	public void userPagingList() {
		/***Given***/ //주어진 환경
		PageVo pageVo = new PageVo(1,10);
	
		/***When***/
		List<UserVo> userList = UserDao.userPagingList(pageVo);
		logger.debug("♬♪♩ userList : {}",userList );
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
	}
	
	/**
	* Method : usersCnt
	* 작성자 : PC13
	* 변경이력 :
	* Method 설명 : 사용자 전체 수 조회 test
	*/
	@Test
	public void usersCnt() {
		/***Given***/
		

		/***When***/
		int num = UserDao.usersCnt();

		/***Then***/
		logger.debug("♬♪♩ num : {}",num );
		assertEquals(102, num);
	}
	
	/**
	* Method : updateUser
	* 작성자 : PC13
	* 변경이력 :
	* @throws ParseException
	* Method 설명 : 사용자 정보 업데이트 테스트
	*/
	@Test
	public void updateUser() throws ParseException {
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("userTest", "대덕인", "중앙로1", "userTest1234",
				"대전광역시 중구 중앙로30", "영민빌딩 204호 입니다.", "34940", sdf.parse("2019-05-31"));

		/***When***/
		int updateCnt = UserDao.updateUser(userVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
}
