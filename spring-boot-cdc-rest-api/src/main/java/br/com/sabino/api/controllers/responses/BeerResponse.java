package br.com.sabino.api.controllers.responses;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BeerResponse {
    private Long id;
    private String name;
    private String ibu;
    private String style;
    private String description;
    private String alcoholTenor;
}
