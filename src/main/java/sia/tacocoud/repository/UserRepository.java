package sia.tacocoud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocoud.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
