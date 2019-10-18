package br.com.sabino.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class BeerContract {

  private UUID id;
  private String name;
  private String ibu;
  private String style;
  private String description;
  private String alcoholTenor;
}
