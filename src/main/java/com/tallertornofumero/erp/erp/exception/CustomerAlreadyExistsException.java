package com.tallertornofumero.erp.erp.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String nif) {
        super("El cliente con el nif '" + nif + "' ya existe.");
    }
}
