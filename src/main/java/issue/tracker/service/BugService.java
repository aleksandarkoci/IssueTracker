package issue.tracker.service;

import java.util.List;

import issue.tracker.entity.Bug;

public interface BugService {

	List<Bug> findAll();
	Bug findOne(Integer id);
	Bug save(Bug bug);
	void delete(Integer id);
	
}
