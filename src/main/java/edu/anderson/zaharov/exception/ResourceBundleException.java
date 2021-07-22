package edu.anderson.zaharov.exception;

/**
 * ResourceBundleException
 */
public class ResourceBundleException extends RuntimeException {

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.
     */
    public ResourceBundleException() {
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     */
    public ResourceBundleException(String message) {
        super(message);
    }
}

