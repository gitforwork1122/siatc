package sia.tacocoud.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sia.tacocoud.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
