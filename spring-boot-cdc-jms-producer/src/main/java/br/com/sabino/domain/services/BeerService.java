package br.com.sabino.domain.services;

import br.com.sabino.api.controllers.requests.BeerRequest;
import br.com.sabino.api.controllers.responses.BeerResponse;
import br.com.sabino.application.JmsMessageSender;
import br.com.sabino.domain.mappers.BeerMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class BeerService {

    private final JmsMessageSender jmsMessageSender;
    private final BeerMapper mapper;

    public BeerResponse create(BeerRequest beerRequest) {
        final var beer = mapper.mapToEntity(beerRequest);
        jmsMessageSender.send(beerRequest);
        return mapper.mapToResponse(beer);
    }
}
