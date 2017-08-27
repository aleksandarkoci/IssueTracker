package issue.tracker.service;

import java.util.List;

import issue.tracker.entity.User;

public interface UserService {

	List<User> findAll();
	User findOne(Integer id);
	User save(User user);
	void delete(Integer id);
	
}
