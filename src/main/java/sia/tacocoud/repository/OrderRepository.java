package sia.tacocoud.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocoud.TacoOrder;
import sia.tacocoud.User;
import java.util.List;

@Repository
public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user);

}
