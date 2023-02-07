package com.teamdex.teamdex.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ArtistsNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String message;

    public ArtistsNotFoundException(String message) {
        this.message = message;
    }

}
