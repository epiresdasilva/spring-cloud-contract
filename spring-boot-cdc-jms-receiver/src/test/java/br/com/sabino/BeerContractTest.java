package br.com.sabino;

import br.com.sabino.contract.BeerContract;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BeerContractTest {

  @Test
  public void beerContract() {
    BeerContract beerContract = new BeerContract();
    beerContract.setId(UUID.randomUUID());
    beerContract.setAlcoholTenor("0.1");
    beerContract.setDescription("Some description");
    beerContract.setIbu("1");
    beerContract.setName("Some name");
    beerContract.setStyle("IPA");

    assertThat(beerContract.getId().getClass()).isEqualTo(UUID.class);
    assertThat(beerContract.getAlcoholTenor().getClass()).isEqualTo(String.class);
    assertThat(beerContract.getDescription().getClass()).isEqualTo(String.class);
    assertThat(beerContract.getIbu().getClass()).isEqualTo(String.class);
    assertThat(beerContract.getName().getClass()).isEqualTo(String.class);
    assertThat(beerContract.getStyle().getClass()).isEqualTo(String.class);
  }
}
