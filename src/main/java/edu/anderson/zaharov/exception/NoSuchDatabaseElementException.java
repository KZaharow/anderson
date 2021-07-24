package edu.anderson.zaharov.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchDatabaseElementException extends RuntimeException {

    public NoSuchDatabaseElementException(String msg) {
        super(msg);
    }
}
