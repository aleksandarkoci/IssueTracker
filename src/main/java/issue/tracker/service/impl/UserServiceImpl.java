package issue.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import issue.tracker.entity.User;
import issue.tracker.repository.UserRepository;
import issue.tracker.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User findOne(Integer id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public User save(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void delete(Integer id) {
		
		userRepository.delete(id);

	}

}
