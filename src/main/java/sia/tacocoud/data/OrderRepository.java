package sia.tacocoud.data;


import org.springframework.data.jpa.repository.JpaRepository;
import sia.tacocoud.model.Order;
import sia.tacocoud.model.User;
import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(User user);

}
