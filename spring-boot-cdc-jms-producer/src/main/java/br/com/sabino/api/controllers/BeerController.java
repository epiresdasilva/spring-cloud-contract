package br.com.sabino.api.controllers;

import br.com.sabino.api.controllers.requests.BeerRequest;
import br.com.sabino.api.controllers.responses.BeerResponse;
import br.com.sabino.domain.services.BeerService;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/beer")
public class BeerController {

    private final BeerService service;

    @PostMapping
    public BeerResponse create(@Valid @RequestBody BeerRequest beerRequest) {
        return service.create(beerRequest);
    }
}

