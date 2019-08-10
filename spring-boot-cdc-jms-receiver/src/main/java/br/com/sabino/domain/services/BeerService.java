package br.com.sabino.domain.services;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.repository.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository;

    public void sendMessageToClient(Beer beer) {
        beerRepository.saveBeer(beer);
    }
}
