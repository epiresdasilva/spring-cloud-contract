package br.com.sabino.jms;

import br.com.sabino.domain.entities.Beer;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    public void send(Beer beer) {
        jmsTemplate.convertAndSend("queue.beer", beer);
    }
}
