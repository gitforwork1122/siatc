package sia.tacocoud.kitchen.rabbit;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sia.tacocoud.kitchen.KitchenUI;
import sia.tacocoud.model.Order;

@Component
public class OrderListener {

    private KitchenUI ui;

    @Autowired
    public OrderListener (KitchenUI ui) {
        this.ui = ui;
    }

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }




}
