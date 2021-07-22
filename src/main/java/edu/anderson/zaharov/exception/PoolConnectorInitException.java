package edu.anderson.zaharov.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PoolConnectorInitException extends RuntimeException {

    public PoolConnectorInitException(String msg) {

        super(msg);
    }
}
