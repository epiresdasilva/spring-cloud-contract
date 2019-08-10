package br.com.sabino.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Beer implements Serializable {
    private UUID id = UUID.randomUUID();
    private String name;
    private String ibu;
    private String style;
    private String description;
    private String alcoholTenor;
}