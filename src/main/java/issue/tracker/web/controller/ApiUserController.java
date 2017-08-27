package issue.tracker.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import issue.tracker.entity.User;
import issue.tracker.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class ApiUserController {

	@Autowired
	private UserService userService;
	
	
	/********************************* getAll *********************************/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> get() {

		List<User> user = new ArrayList<User>();
		
		user = userService.findAll();

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	/********************************* getById *********************************/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> get(@PathVariable Integer id) {

		User user = userService.findOne(id);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	/********************************* delete *********************************/
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable Integer id) {

		userService.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	/*********************************
	 * post add
	 *********************************/

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> add(@RequestBody User newUser) {

		User user = new User();

		if (newUser.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			user = userService.save(newUser);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	/*********************************
	 * put edit
	 *********************************/
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> edit(@PathVariable Integer id, @RequestBody User editUser) {

		if (!id.equals(editUser.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = userService.save(editUser);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
