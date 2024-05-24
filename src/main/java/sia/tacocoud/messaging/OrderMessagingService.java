package sia.tacocoud.messaging;

import sia.tacocoud.model.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
