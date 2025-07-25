package com.tallertornofumero.erp.erp.exception;

public class InvoiceLineNotExistsException extends RuntimeException {
    public InvoiceLineNotExistsException(String invoiceLineNumber) {
        super("El albarán con número '" + invoiceLineNumber + "' no existe.");
    }
}
