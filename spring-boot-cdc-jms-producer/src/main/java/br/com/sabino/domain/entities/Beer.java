package br.com.sabino.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Beer implements Serializable {
    private UUID id;
    private String name;
    private String ibu;
    private String style;
    private String description;

    @PostConstruct
    public void init() {
       id = UUID.randomUUID();
    }
}