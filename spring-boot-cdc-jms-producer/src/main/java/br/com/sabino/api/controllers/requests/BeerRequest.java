package br.com.sabino.api.controllers.requests;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class BeerRequest {
    @NotBlank(message="Name can not be empty")
    private String name;

    @NotBlank(message="IBU can not be empty")
    private String ibu;

    @NotBlank(message="Style can not be empty")
    private String style;

    @NotBlank(message="Description can not be empty")
    private String description;

    @NotBlank(message="Alcohol Tenor can not be empty")
    private String alcoholTenor;
}
