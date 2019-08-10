package br.com.sabino.api.handlers.errors;

import lombok.Getter;

@Getter
public class ErrorDetails {

    private String message;

    public ErrorDetails(String message){
        super();
        this.message = message;
    }


}

