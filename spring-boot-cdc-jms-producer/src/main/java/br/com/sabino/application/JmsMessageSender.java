package br.com.sabino.application;

import br.com.sabino.api.controllers.requests.BeerRequest;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JmsMessageSender {

    private final JmsTemplate jmsTemplate;

    public void send(BeerRequest beerRequest) {
        jmsTemplate.convertAndSend("queue.beer", beerRequest);
    }
}
