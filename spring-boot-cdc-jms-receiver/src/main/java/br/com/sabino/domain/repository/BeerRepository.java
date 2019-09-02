package br.com.sabino.domain.repository;

import br.com.sabino.domain.entities.Beer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(path = "/api/beer", value = "BeerClient", url = "${beerapi.url}")
public interface BeerRepository {
  @PostMapping
  void saveBeer(Beer beer);
}
