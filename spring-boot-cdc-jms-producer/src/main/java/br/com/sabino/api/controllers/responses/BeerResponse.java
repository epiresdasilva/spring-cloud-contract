package br.com.sabino.api.controllers.responses;

import lombok.Builder;
import lombok.Getter;
import java.util.UUID;

@Getter
@Builder
public class BeerResponse {
    private UUID id;
    private String name;
    private String ibu;
    private String style;
    private String description;
    private String alcoholTenor;
}
