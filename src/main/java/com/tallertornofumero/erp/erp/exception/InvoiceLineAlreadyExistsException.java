package com.tallertornofumero.erp.erp.exception;

public class InvoiceLineAlreadyExistsException extends RuntimeException {
    public InvoiceLineAlreadyExistsException(String invoiceLineNumber) {
        super("El albarán con el numero '" + invoiceLineNumber + "' ya existe.");
    }
}
