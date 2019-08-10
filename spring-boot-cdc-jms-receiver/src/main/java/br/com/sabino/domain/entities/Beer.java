package br.com.sabino.domain.entities;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Beer implements Serializable {
    private UUID id;
    private String name;
    private String ibu;
    private String style;
    private String description;
    private String alcoholTenor;
}