package sia.tacocoud.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocoud.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
