package sia.tacocoud.messaging;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.messaging.MessagingException;

public interface MessageConverter {
    MessageConverter toMessageConverter(Object object, Session session) throws JMSException, MessageConversionException;
    Object fromMessage(Message message);
}
