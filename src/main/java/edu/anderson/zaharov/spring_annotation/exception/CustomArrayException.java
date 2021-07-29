package edu.anderson.zaharov.spring_annotation.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomArrayException extends Exception {

    private final String msg;
}
