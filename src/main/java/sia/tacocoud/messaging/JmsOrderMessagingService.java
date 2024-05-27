//package sia.tacocoud.messaging;
//
//import jakarta.jms.Destination;
//import jakarta.jms.JMSException;
//import jakarta.jms.Message;
//import jakarta.jms.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessagePostProcessor;
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import sia.tacocoud.model.Order;
//
//
//@Service
//public class JmsOrderMessagingService implements OrderMessagingService {
//    private JmsTemplate jms;
//
//    @Autowired
//    public  JmsOrderMessagingService (JmsTemplate jms) {
//        this.jms = jms;
//    }
//
//
//    @Override
//    public void sendOrder(Order order) {
//        jms.convertAndSend("tacocloud.order.queue", order, message -> {
//            message.setStringProperty("X_ORDER_SOURCE", "WEB");
//            return message;
//        });
//    }
//}
