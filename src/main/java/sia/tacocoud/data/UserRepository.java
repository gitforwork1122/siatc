package sia.tacocoud.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sia.tacocoud.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
