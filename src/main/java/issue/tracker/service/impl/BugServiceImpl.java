package issue.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import issue.tracker.entity.Bug;
import issue.tracker.repository.BugRepository;
import issue.tracker.service.BugService;

@Service
@Transactional
public class BugServiceImpl implements BugService {

	@Autowired
	private BugRepository bugRepository;
	
	@Override
	public List<Bug> findAll() {
		
		return bugRepository.findAll();
	}

	@Override
	public Bug findOne(Integer id) {
		
		return bugRepository.findOne(id);
	}

	@Override
	public Bug save(Bug bug) {
		
		return bugRepository.save(bug);
	}

	@Override
	public void delete(Integer id) {
		
		bugRepository.delete(id);

	}

}
