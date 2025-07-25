package com.tallertornofumero.erp.erp.exception;

public class UsernameNotExistsException extends RuntimeException {
    public UsernameNotExistsException(String username) {
        super("El usuario '" + username + "' no existe.");
    }
}
