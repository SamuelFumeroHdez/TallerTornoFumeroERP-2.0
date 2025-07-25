package com.tallertornofumero.erp.erp.exception;

public class CustomerNotExistsException extends RuntimeException {
    public CustomerNotExistsException(String nif) {
        super("El cliente con el nif '" + nif + "' no existe.");
    }
}
