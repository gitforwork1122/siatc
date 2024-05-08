package sia.tacocoud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.tacocoud.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
