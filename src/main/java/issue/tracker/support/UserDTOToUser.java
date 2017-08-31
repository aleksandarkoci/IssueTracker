package issue.tracker.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import issue.tracker.entity.Bug;
import issue.tracker.entity.User;
import issue.tracker.service.UserService;
import issue.tracker.web.dto.UserDTO;

@Component
public class UserDTOToUser implements Converter<UserDTO, User> {

	@Autowired
	private UserService userService;

	@Override
	public User convert(UserDTO source) {
		
		User user;
		
		if (source.getId() == null) {
			user = new User();
			List<Bug> bugList = new ArrayList<>();
			Bug bug = new Bug(null, source.getBug(), user);
			bugList.add(bug);

			user.setBugList(bugList);
		} else {
			user = userService.findOne(source.getId());
		}
		
		user.setId(source.getId());
		user.setEmail(source.getEmail());
		user.setPassword(source.getPassword());
		user.setUsername(source.getUsername());
		return user;
	}

}
