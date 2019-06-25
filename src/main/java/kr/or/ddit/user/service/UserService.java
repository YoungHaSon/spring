package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

@Service
public class UserService implements IuserService {

	@Resource(name = "userDao")
	private IuserDao userDao;

	/**
	 * Method : userList 작성자 : PC13 변경이력 :
	 * 
	 * @return Method 설명 : 전체 회원 리스트 받아오는!
	 */
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	/**
	 * Method : insertUser 작성자 : PC13 변경이력 :
	 * 
	 * @param userVo
	 * @return Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	/**
	 * Method : deleteUser 작성자 : PC13 변경이력 :
	 * 
	 * @param userId
	 * @return Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	/**
	 * Method : getUser 작성자 : PC13 변경이력 :
	 * 
	 * @param userId
	 * @return Method 설명 : 사용자 정보 조회
	 */
	@Override
	public UserVo getUser(String userId) {
		return userDao.getUser(userId);
	}

	@Override
	public Map<String, Object>	userPagingList(PageVo pageVo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVo));
		
		//usersCnt --> paginationSize를 계산해서 변경
		int usersCnt = userDao.usersCnt();
		//pageSize = pageVo.getPageSize();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		return resultMap;
	}

	@Override
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}
}
