package issue.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import issue.tracker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
