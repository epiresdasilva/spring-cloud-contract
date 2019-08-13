package br.com.sabino.api.controllers;

import br.com.sabino.api.controllers.requests.BeerRequest;
import br.com.sabino.api.controllers.responses.BeerResponse;
import br.com.sabino.domain.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/beer")
public class BeerController {

    private final BeerService service;

    @GetMapping
    public List<BeerResponse> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BeerResponse getOne(@PathVariable("id") @NotNull @Min(1) Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public BeerResponse create(@Valid @RequestBody BeerRequest beerRequest) {
        return service.create(beerRequest);
    }

    @PutMapping("/{id}")
    public BeerResponse update(@PathVariable("id") @NotNull @Min(1) Long id, @Valid @RequestBody BeerRequest beerRequest) {
        return service.update(id, beerRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") @NotNull @Min(1) Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

