package br.com.sabino.domain.repository;

import br.com.sabino.domain.entities.Beer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "BeerClient", url = "https://localhost:8082/api/beer")
public interface BeerRepository {
    @PostMapping
    void saveBeer(Beer beer);
}
