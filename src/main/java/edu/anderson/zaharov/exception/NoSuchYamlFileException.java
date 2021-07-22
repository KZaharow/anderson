package edu.anderson.zaharov.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchYamlFileException extends RuntimeException {

    public NoSuchYamlFileException(String msg) {

        super(msg);
    }
}