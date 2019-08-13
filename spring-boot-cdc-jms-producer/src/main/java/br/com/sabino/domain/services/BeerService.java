package br.com.sabino.domain.services;

import br.com.sabino.jms.MessageSender;
import br.com.sabino.domain.entities.Beer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class BeerService {

    private final MessageSender messageSender;

    public Beer create(Beer beer) {
        beer.setId(UUID.randomUUID());
        messageSender.send(beer);
        return beer;
    }
}
