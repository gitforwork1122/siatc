package sia.tacocoud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sia.tacocoud.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
