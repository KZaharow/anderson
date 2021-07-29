package edu.anderson.zaharov.spring_annotation.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchDatabaseElementException extends RuntimeException {

    public NoSuchDatabaseElementException(String msg) {
        super(msg);
    }
}
