package edu.anderson.zaharov.spring_annotation.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchYamlFileException extends RuntimeException {

    public NoSuchYamlFileException(String msg) {

        super(msg);
    }
}