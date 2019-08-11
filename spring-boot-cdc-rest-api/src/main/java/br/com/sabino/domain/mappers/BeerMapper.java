package br.com.sabino.domain.mappers;

import br.com.sabino.api.controllers.requests.BeerRequest;
import br.com.sabino.api.controllers.responses.BeerResponse;
import br.com.sabino.domain.entities.Beer;
import org.springframework.stereotype.Component;

@Component
public class BeerMapper {

    public Beer mapToEntity(BeerRequest request) {
        return Beer.builder().name(request.getName())
                .ibu(request.getIbu())
                .description(request.getDescription())
                .style(request.getStyle())
                .alcoholTenor(request.getAlcoholTenor())
                .build();
    }

    public BeerResponse mapToResponse(Beer beer) {
        return BeerResponse.builder().name(beer.getName())
                .id(beer.getId())
                .ibu(beer.getIbu())
                .description(beer.getDescription())
                .style(beer.getStyle())
                .alcoholTenor(beer.getAlcoholTenor())
                .build();
    }

}
