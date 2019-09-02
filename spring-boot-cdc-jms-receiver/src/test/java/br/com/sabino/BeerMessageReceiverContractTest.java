package br.com.sabino;

import au.com.dius.pact.consumer.MessagePactBuilder;
import au.com.dius.pact.consumer.MessagePactProviderRule;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.model.v3.messaging.MessagePact;
import br.com.sabino.application.jms.BeerMessageReceiver;
import br.com.sabino.domain.entities.Beer;
import br.com.sabino.domain.services.BeerService;
import com.google.gson.Gson;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeerMessageReceiverContractTest {

  @Rule public MessagePactProviderRule mockProvider = new MessagePactProviderRule(this);
  private byte[] currentMessage;

  @InjectMocks private BeerMessageReceiver beerMessageReceiver;
  @Mock private BeerService beerService;

  @Pact(provider = "beerproducer", consumer = "beerreceiver")
  public MessagePact beerMessagePact(MessagePactBuilder builder) {
    doNothing().when(beerService).sendMessageToClient(any());

    PactDslJsonBody body =
        new PactDslJsonBody()
            .stringType("name")
            .stringType("ibu")
            .stringType("style")
            .stringType("description")
            .stringType("alcoholTenor");
    return builder.expectsToReceive("a beer message is received").withContent(body).toPact();
  }

  @Test
  @PactVerification("beerMessagePact")
  public void verifyCreatePersonPact() throws IOException {
    beerMessageReceiver.onReceiverQueue(
        new Gson().fromJson(new String(this.currentMessage), Beer.class));
  }

  /** This method is called by the Pact framework. */
  public void setMessage(byte[] message) {
    this.currentMessage = message;
  }
}
