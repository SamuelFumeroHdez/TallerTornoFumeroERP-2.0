package com.tallertornofumero.erp.erp.repository;

import com.tallertornofumero.erp.erp.model.Customer;
import com.tallertornofumero.erp.erp.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, String> {
    boolean existsByInvoiceNumber(Integer invoiceNumber);
    Invoice findByInvoiceNumber(Integer invoiceNumber);
    List<Invoice> findByCustomer_Nif(String nif);
}
