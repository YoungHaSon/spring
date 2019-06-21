package kr.or.ddit.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.UserVo;

@Service
public class UserService implements IuserService {

	@Resource(name="userDao")
	private IuserDao userDao;
	
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

}
