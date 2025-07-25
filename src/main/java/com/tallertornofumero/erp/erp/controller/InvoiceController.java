package com.tallertornofumero.erp.erp.controller;

import com.tallertornofumero.erp.erp.model.Customer;
import com.tallertornofumero.erp.erp.model.Invoice;
import com.tallertornofumero.erp.erp.model.InvoiceLine;
import com.tallertornofumero.erp.erp.service.CustomerService;
import com.tallertornofumero.erp.erp.service.InvoiceLineService;
import com.tallertornofumero.erp.erp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceLineService invoiceLineService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/invoices")
    public String listInvoices(Model model){
        List<Invoice> invoices = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoices);
        model.addAttribute("invoice", new Invoice());
        return "invoices/list";
    }

    @GetMapping("invoices/create")
    public String createInvoice(Model model){
        List<InvoiceLine> invoiceLines = invoiceLineService.getInvoiceLinesByInvoice(0);
        List<Customer> customers = customerService.getAllCustomers();
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(new Date());
        model.addAttribute("invoiceLines", invoiceLines);
        model.addAttribute("invoiceLine", new InvoiceLine());
        model.addAttribute("invoice", invoice);
        model.addAttribute("customers", customers);
        return "invoices/form";

    }


}
