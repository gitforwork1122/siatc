package sia.tacocoud.messaging;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sia.tacocoud.data.OrderRepository;
import sia.tacocoud.model.Order;

@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderApiContorller {

    private final OrderRepository repo;
    private final OrderMessagingService messagingService;

    public OrderApiContorller(OrderRepository repo, OrderMessagingService messagingService) {
        this.repo = repo;
        this.messagingService = messagingService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order postOrder(@RequestBody Order order) {
        messagingService.sendOrder(order);
        return repo.save(order);
    }




}


