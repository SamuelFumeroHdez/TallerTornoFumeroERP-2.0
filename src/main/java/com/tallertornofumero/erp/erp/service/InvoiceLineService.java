package com.tallertornofumero.erp.erp.service;

import com.tallertornofumero.erp.erp.exception.InvoiceLineAlreadyExistsException;
import com.tallertornofumero.erp.erp.exception.InvoiceLineNotExistsException;
import com.tallertornofumero.erp.erp.exception.InvoiceNotExistsException;
import com.tallertornofumero.erp.erp.model.Invoice;
import com.tallertornofumero.erp.erp.model.InvoiceLine;
import com.tallertornofumero.erp.erp.repository.InvoiceLineRepository;
import com.tallertornofumero.erp.erp.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceLineService {

    private final InvoiceLineRepository invoiceLineRepository;
    private final InvoiceRepository invoiceRepository;

    public List<InvoiceLine> getAllInvoiceLines(){
        return invoiceLineRepository.findAll();
    }

    public List<InvoiceLine> getInvoiceLinesByInvoice(Integer invoiceNumber){
//        Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber);
//        if(invoice == null){
//            if(invoiceNumber!=0)
//                throw new InvoiceNotExistsException(invoiceNumber.toString());
//        }
//        return invoiceLineRepository.findByInvoice_InvoiceNumber(invoiceNumber);

        Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber);
        List<InvoiceLine> lines = invoiceLineRepository.findByInvoice(invoice);
        return lines;

    }

    public InvoiceLine createInvoiceLine(InvoiceLine invoiceLine){
        boolean exists = invoiceLineRepository.existsByInvoiceLineNumber(invoiceLine.getInvoiceLineNumber());
        if(exists){
            throw new InvoiceLineAlreadyExistsException(invoiceLine.getInvoiceLineNumber().toString());
        }
        return invoiceLineRepository.save(invoiceLine);
    }

    public InvoiceLine updateInvoiceLine(Integer invoiceLineNumber, InvoiceLine invoiceLine){
        InvoiceLine invoiceLineDB = invoiceLineRepository.findByInvoiceLineNumber(invoiceLineNumber);

        if(invoiceLineDB == null){
            throw new InvoiceLineNotExistsException(invoiceLine.getInvoiceLineNumber().toString());
        }

        invoiceLineDB.setInvoiceLineNumber(invoiceLine.getInvoiceLineNumber());
        invoiceLineDB.setPrice(invoiceLine.getPrice());
        invoiceLineDB.setDescription(invoiceLineDB.getDescription());


        return invoiceLineRepository.save(invoiceLineDB);
    }
}
