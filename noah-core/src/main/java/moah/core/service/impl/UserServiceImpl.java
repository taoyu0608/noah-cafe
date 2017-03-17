package moah.core.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import moah.core.dao.UserDao;
import moah.core.model.User;
import moah.core.service.UserService;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(String username) {
		userDao.delete(username);
	}

	@Override
	public boolean exists(String username) {
		return userDao.exists(username);
	}

	@Override
	public User getUserByUsername(String username) {

		if (StringUtils.isEmpty(username)) {
			return null;
		}

		User user = userDao.findOne(username);
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	@Override
	public String getFullUsername(String username) {

		if (StringUtils.isBlank(username)) {
			return StringUtils.EMPTY;
		}

		boolean exists = this.exists(username);
		if (!exists) {
			return username;
		}

		User user = this.getUserByUsername(username);
		return String.format("%s ( %s )", user.getName(), user.getLocalName());
	}

	@Override
	public void registerUser(User user) {
		String encryptPassword = encryptPassword(user.getPassword());
		Date createdDate = new Date();

		user.setPassword(encryptPassword);
//		user.setCreatedDate(createdDate);
//		user.setUpdatedDate(createdDate);

		userDao.save(user);
	}

	@Override
	public Boolean weakPassword(User user) {
		return false;
	}

	@Override
	public Boolean editUser(User user) {

		String encryptPassword = encryptPassword(user.getPassword());
		String[] oldPasswords = new String[0];
		List<String> passwords = Lists.newArrayList();
		passwords.add(encryptPassword);

		if (user.getOldPasswords() != null) {
			oldPasswords = user.getOldPasswords().split(",", -1);
			int length = oldPasswords.length;
			for (int i = 0; i < 23; i++) {
				if (i == length) {
					break;
				}
				passwords.add(oldPasswords[i]);
			}
		}

		String joinedPassword = String.join(",", passwords);
		user.setOldPasswords(joinedPassword);
		user.setPassword(encryptPassword);
//		user.setUpdatedDate(new Date());

		userDao.save(user);

		return true;
	}

	private String encryptPassword(String password) {

//		String encryptPassword = passwordEncoder.encode(password);
		String encryptPassword = "";
		return encryptPassword;
	}

}
