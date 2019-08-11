package br.com.sabino.domain.services;

import br.com.sabino.api.controllers.requests.BeerRequest;
import br.com.sabino.api.controllers.responses.BeerResponse;
import br.com.sabino.api.handlers.exception.BeerNotFoundException;
import br.com.sabino.domain.mappers.BeerMapper;
import br.com.sabino.domain.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository repository;
    private final BeerMapper mapper;

    @Transactional(readOnly = true)
    public BeerResponse findOne(Long id) {
        final var beer = repository.findById(id);
        return beer
                .map(mapper::mapToResponse)
                .orElseThrow(BeerNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<BeerResponse> findAll() {
        final var beers = repository.findAll();
        return beers.stream().map(mapper::mapToResponse).collect(Collectors.toList());
    }

    public BeerResponse create(BeerRequest beerRequest) {
        final var beer = mapper.mapToEntity(beerRequest);
        final var beerSaved = repository.save(beer);
        return mapper.mapToResponse(beerSaved);
    }

    public BeerResponse update(Long id, BeerRequest beerRequest) {
        final var updatedBeer = repository.findById(id)
                .map(beer -> {
                    beer.setName(beerRequest.getName());
                    beer.setStyle(beerRequest.getStyle());
                    beer.setDescription(beerRequest.getDescription());
                    beer.setIbu(beerRequest.getIbu());
                    beer.setAlcoholTenor(beerRequest.getAlcoholTenor());
                    return repository.save(beer);
                }).orElseThrow(BeerNotFoundException::new);
        return mapper.mapToResponse(updatedBeer);
    }

    public void delete(Long id) {
        final var beer = repository.findById(id);
        beer.ifPresent(consumer ->
                repository.deleteById(consumer.getId()));
    }
}
