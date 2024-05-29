package sia.tacocoud.kitchen;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocoud.data.OrderRepository;
import sia.tacocoud.kitchen.rabbit.RabbitOrderReceiver;
import sia.tacocoud.model.Order;

@Profile({"rabbitmq-template"})
@Controller
@RequestMapping("kitchen/orders")
@RequiredArgsConstructor
public class OrderReceiverController {

    private final OrderRepository orderRepository;
    private final RabbitOrderReceiver rabbitOrderReceiver;

    @GetMapping("/receive")
    public String receiveOrder(Model model) {
        Order order = rabbitOrderReceiver.receiveOrder();

        if (order != null) {
            model.addAttribute("order", order);
            return "receiveOrder";
        }
        return "noOrder";
    }
}
