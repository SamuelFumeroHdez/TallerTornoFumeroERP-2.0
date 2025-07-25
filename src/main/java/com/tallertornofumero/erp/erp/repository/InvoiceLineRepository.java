package com.tallertornofumero.erp.erp.repository;

import com.tallertornofumero.erp.erp.model.Customer;
import com.tallertornofumero.erp.erp.model.Invoice;
import com.tallertornofumero.erp.erp.model.InvoiceLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceLineRepository extends MongoRepository<InvoiceLine, String> {
    boolean existsByInvoiceLineNumber(Integer invoiceLineNumber);
    InvoiceLine findByInvoiceLineNumber(Integer invoiceLineNumber);
    List<InvoiceLine> findByInvoice_InvoiceNumber(Integer invoiceNumber);
    List<InvoiceLine> findByInvoice(Invoice invoice);
}
