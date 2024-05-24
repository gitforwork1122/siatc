package sia.tacocoud.kitchen.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sia.tacocoud.messaging.MessageConverter;
import sia.tacocoud.model.Order;

@Component
public class RabbitOrderReceiver {
    private final RabbitTemplate rabbit;


    @Autowired
    public RabbitOrderReceiver (RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    public Order receiveOrder() {
        return (Order) rabbit.receiveAndConvert("tacocloud.order.queue");
    }



}
