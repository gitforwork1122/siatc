package sia.tacocoud.messaging;


import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sia.tacocoud.data.OrderRepository;
import sia.tacocoud.model.Order;

@RestController
@RequestMapping(path = "/rabbit/orders", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderApiController {

    private static final Logger log = LoggerFactory.getLogger(OrderApiController.class);
    private final OrderRepository repo;
    private final OrderMessagingService messagingService;

    public OrderApiController(OrderRepository repo, OrderMessagingService messagingService) {
        this.repo = repo;
        this.messagingService = messagingService;
    }


    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void postOrder(@RequestBody Order order) {
        messagingService.sendOrder(order);
        log.info("CREATED ORDER: {}", order.toString());
//        return repo.save(order);
    }
}


