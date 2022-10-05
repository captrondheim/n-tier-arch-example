package com.capgemini.ignite.exceptions;

public abstract class DomainException extends RuntimeException {
    protected DomainException(String message) {
        super(message);
    }
}
