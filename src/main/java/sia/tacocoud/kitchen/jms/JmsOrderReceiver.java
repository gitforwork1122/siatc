//package sia.tacocoud.kitchen.jms;
//
//
//import jakarta.jms.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Component;
//import sia.tacocoud.kitchen.OrderReceiver;
//import sia.tacocoud.messaging.MessageConverter;
//import sia.tacocoud.model.Order;
//
//@Component
//public class JmsOrderReceiver implements OrderReceiver {
//
//    private JmsTemplate jms;
//
//    public JmsOrderReceiver(JmsTemplate jms) {
//        this.jms = jms;
//    }
//
//    @Override
//    public Order receiveOrder() {
//        return (Order) jms.receiveAndConvert("tacocloud.order.queue");
//    }
//
//}
