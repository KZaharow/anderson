package edu.anderson.zaharov.spring_annotation.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PoolConnectorInitException extends RuntimeException {

    public PoolConnectorInitException(String msg) {

        super(msg);
    }
}
