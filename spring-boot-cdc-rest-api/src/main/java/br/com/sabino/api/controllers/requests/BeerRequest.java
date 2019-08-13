package br.com.sabino.api.controllers.requests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BeerRequest {
    private String name;
    private String ibu;
    private String style;
    private String description;
    private String alcoholTenor;
}
