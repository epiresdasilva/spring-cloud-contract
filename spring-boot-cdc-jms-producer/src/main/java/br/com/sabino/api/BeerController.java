package br.com.sabino.api;

import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/beer")
public class BeerController {

    private final BeerService service;

    @PostMapping
    public Beer create(@Valid @RequestBody Beer beerRequest) {
        return service.create(beerRequest);
    }
}

