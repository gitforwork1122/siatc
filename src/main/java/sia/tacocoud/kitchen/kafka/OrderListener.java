package sia.tacocoud.kitchen.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sia.tacocoud.commandLineRunner.StartDataConfig;
import sia.tacocoud.kitchen.KitchenUI;
import sia.tacocoud.model.Order;

@Component
public class OrderListener {

    private static final Logger log = LoggerFactory.getLogger(StartDataConfig.class);

    private KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @KafkaListener(topics="tacocloud.orders.topic")
    public void handle(Order order, ConsumerRecord<String, Order> record) {
        log.info("Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());
        ui.displayOrder(order);
    }

}
