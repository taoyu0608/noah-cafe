package noah.core.service;

import java.util.List;

import noah.core.model.User;

public interface UserService {

	User saveUser(User user);

	void deleteUser(String username);

	User getUserByUsername(String username);

	boolean exists(String username);

	List<User> findAllUsers();

	String getFullUsername(String username);

	void registerUser(User user);

	Boolean editUser(User user);

	Boolean weakPassword(User user);

}
