package br.com.sabino;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.repository.BeerRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
//    webEnvironment = SpringBootTest.WebEnvironment.NONE,
    properties = {"beerapi.url: http://localhost:8888", "addresses.ribbon.listOfServers: localhost:8888"})
public class BeerApiContractTest {

  @Rule
  public PactProviderRuleMk2 provider =
      new PactProviderRuleMk2("beerreceiver", "localhost", 8888, this);

  @Autowired private BeerRepository beerRepository;

  @Pact(provider = "beerreceiver", consumer = "beerapi")
  public RequestResponsePact pactUserExists(PactDslWithProvider builder) {
    return builder
        .given("Beer doesn't exists")
        .uponReceiving("A request to /api/beer")
        .path("/api/beer")
        .method("POST")
        .willRespondWith()
        .status(200)
        .body(
            new PactDslJsonBody()
                .stringType("name")
                .stringType("ibu")
                .stringType("style")
                .stringType("description")
                .stringType("alcoholTenor"))
        .toPact();
  }

  @Test
  @PactVerification(fragment = "pactBeerSave")
  public void saveBeer() {
    beerRepository.saveBeer(
        Beer.builder()
            .alcoholTenor("1")
            .description("IPA")
            .ibu("1")
            .name("IPA")
            .style("IPA")
            .build());
  }
}
