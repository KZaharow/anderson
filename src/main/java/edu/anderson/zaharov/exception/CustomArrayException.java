package edu.anderson.zaharov.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomArrayException extends Exception {

    private final String msg;
}
