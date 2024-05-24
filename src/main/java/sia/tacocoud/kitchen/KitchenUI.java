package sia.tacocoud.kitchen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sia.tacocoud.model.Order;

@Slf4j
@Component
public class KitchenUI {

    public void displayOrder(Order order) {
        log.info("RECIVED ORDER: " + order);
    }
}
