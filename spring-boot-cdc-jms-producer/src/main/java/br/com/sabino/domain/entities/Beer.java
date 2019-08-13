package br.com.sabino.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Beer implements Serializable {
    @JsonIgnore
    private UUID id;
    private String name;
    private String ibu;
    private String style;
    private String description;
    private String alcoholTenor;
}