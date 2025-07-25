package com.tallertornofumero.erp.erp.exception;

public class InvoiceNotExistsException extends RuntimeException {
    public InvoiceNotExistsException(String invoiceNumber) {
        super("La factura con el número '" + invoiceNumber + "' no existe.");
    }
}
