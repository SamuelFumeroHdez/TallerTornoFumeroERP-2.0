package com.tallertornofumero.erp.erp.service;

import com.tallertornofumero.erp.erp.exception.*;
import com.tallertornofumero.erp.erp.model.Customer;
import com.tallertornofumero.erp.erp.model.Invoice;
import com.tallertornofumero.erp.erp.model.InvoiceLine;
import com.tallertornofumero.erp.erp.model.User;
import com.tallertornofumero.erp.erp.repository.CustomerRepository;
import com.tallertornofumero.erp.erp.repository.InvoiceRepository;
import com.tallertornofumero.erp.erp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;

    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    public List<Invoice> getInvoiceLineBycustomer(String nif){
        Customer invoice = customerRepository.findByNif(nif);
        if(invoice == null){
            throw new CustomerNotExistsException(nif);
        }
        return invoiceRepository.findByCustomer_Nif(nif);
    }

    public Invoice createInvoiceLine(Invoice invoice){
        boolean exists = invoiceRepository.existsByInvoiceNumber(invoice.getInvoiceNumber());
        if(exists){
            throw new InvoiceLineAlreadyExistsException(invoice.getInvoiceNumber().toString());
        }
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoiceLine(Integer invoiceNumber, Invoice invoice){
        Invoice invoiceDB = invoiceRepository.findByInvoiceNumber(invoiceNumber);

        if(invoiceDB == null){
            throw new InvoiceNotExistsException(invoice.getInvoiceNumber().toString());
        }

        invoiceDB.setInvoiceNumber(invoice.getInvoiceNumber());
        invoiceDB.setInvoiceDate(invoice.getInvoiceDate());
        invoiceDB.setSubtotal(invoice.getSubtotal());
        invoiceDB.setHasTax(invoice.isHasTax());
        invoiceDB.setTaxPercent(invoice.getTaxPercent());
        invoiceDB.setTotal(invoice.getTotal());


        return invoiceRepository.save(invoiceDB);
    }
}
