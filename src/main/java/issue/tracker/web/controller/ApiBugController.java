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

import issue.tracker.entity.Bug;
import issue.tracker.service.BugService;

@RestController
@RequestMapping(value="/api/bug")
public class ApiBugController {

	@Autowired
	private BugService bugService;
	
	
	/********************************* getAll *********************************/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Bug>> get() {

		List<Bug> bug = new ArrayList<Bug>();
		
		bug = bugService.findAll();

		return new ResponseEntity<>(bug, HttpStatus.OK);
	}
	
	
	/********************************* getById *********************************/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Bug> get(@PathVariable Integer id) {

		Bug bug = bugService.findOne(id);

		if (bug == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(bug, HttpStatus.OK);
	}
	
	
	/********************************* delete *********************************/
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Bug> delete(@PathVariable Integer id) {

		bugService.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	/*********************************
	 * post add
	 *********************************/

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Bug> add(@RequestBody Bug newBug) {

		Bug bug = new Bug();

		if (newBug.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			bug = bugService.save(newBug);
		}

		return new ResponseEntity<>(bug, HttpStatus.OK);
	}
	
	
	/*********************************
	 * put edit
	 *********************************/
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Bug> edit(@PathVariable Integer id, @RequestBody Bug editBug) {

		if (!id.equals(editBug.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Bug bug = bugService.save(editBug);

		return new ResponseEntity<>(bug, HttpStatus.OK);
	}
}
