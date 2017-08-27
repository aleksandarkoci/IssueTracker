package issue.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import issue.tracker.entity.Bug;

@Repository
public interface BugRepository extends JpaRepository<Bug, Integer> {

}
