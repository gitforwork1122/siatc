package sia.tacocoud.data;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.tacocoud.model.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
