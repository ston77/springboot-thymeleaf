package shan.yan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shan.yan.dao.UserDao;
import shan.yan.domain.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User getById(int id) {
		return userDao.getById(id);
	}
	
	@Transactional
	public boolean tx() {
		User u1 = new User();
		u1.setId(2);
		u1.setUid("222");
		u1.setUname("2name");
		userDao.insert(u1);
		
		User u2 = new User();
		u2.setId(1);
		u2.setUid("12");
		u2.setUname("1name");
		userDao.insert(u2);
		return true;
	}
}
