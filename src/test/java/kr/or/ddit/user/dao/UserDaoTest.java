package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEvn;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends LogicTestEvn {

	@Resource(name = "userDao")
	private IuserDao UserDao;

	@Test
	public void userListTest() {
		/*** Given ***/

		/*** When ***/
		List<UserVo> userList = UserDao.userList();

		/*** Then ***/
		assertNotNull(userList);
		assertTrue(userList.size() >= 100);
	}

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

}
