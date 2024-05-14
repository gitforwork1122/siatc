package sia.tacocoud.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocoud.model.Order;
import sia.tacocoud.model.User;
import java.util.List;

@Repository
public interface OrderRepository
        extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(User user);

}
