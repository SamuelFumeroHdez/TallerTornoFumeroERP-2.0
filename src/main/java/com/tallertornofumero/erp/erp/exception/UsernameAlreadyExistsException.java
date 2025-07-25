package com.tallertornofumero.erp.erp.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super("El usuario con el nombre de usuario '" + username + "' ya existe.");
    }
}
