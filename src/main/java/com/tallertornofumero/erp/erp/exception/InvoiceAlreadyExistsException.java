package com.tallertornofumero.erp.erp.exception;

public class InvoiceAlreadyExistsException extends RuntimeException {
    public InvoiceAlreadyExistsException(String invoiceNumber) {
        super("La factura con el numero '" + invoiceNumber + "' ya existe.");
    }
}
