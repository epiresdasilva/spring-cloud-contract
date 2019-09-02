package br.com.sabino;

import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import br.com.sabino.jms.MessageSender;
import com.google.gson.Gson;
import org.junit.runner.RunWith;

import java.util.Collections;

import static org.mockito.Mockito.mock;

@RunWith(PactRunner.class)
@Provider("beerproducer")
@PactFolder("../spring-boot-cdc-jms-receiver/target/pacts")
public class BeerServiceTest {

    @TestTarget
    public final Target target =
            new CustomAmqpTarget(Collections.singletonList("br.com.sabino"));

    private MessageSender messageSender = mock(MessageSender.class);
    private BeerService beerService = new BeerService(messageSender);

    @PactVerifyProvider("a beer message is received")
    public String createBeerMessage() {
        Beer beer = beerService.create(Beer.builder().alcoholTenor("1").description("IPA").ibu("1").name("IPA").style("IPA").build());
        return new Gson().toJson(beer);
    }

}