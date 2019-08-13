package br.com.sabino.application.jms;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BeerMessageReceiver {

    private final BeerService beerService;

    @JmsListener(destination = "queue.beer", containerFactory = "queueListenerFactory")
    public void onReceiverQueue(Beer beer) {
        beerService.sendMessageToClient(beer);
    }
}
