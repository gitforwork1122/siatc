package sia.tacocoud.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocoud.Order;
import sia.tacocoud.User;
import java.util.List;

@Repository
public interface OrderRepository
        extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(User user);

}
