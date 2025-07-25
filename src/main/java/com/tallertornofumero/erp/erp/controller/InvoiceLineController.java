package com.tallertornofumero.erp.erp.controller;

import com.tallertornofumero.erp.erp.model.Customer;
import com.tallertornofumero.erp.erp.model.Invoice;
import com.tallertornofumero.erp.erp.model.InvoiceLine;
import com.tallertornofumero.erp.erp.service.InvoiceLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class InvoiceLineController {

    @Autowired
    private InvoiceLineService invoiceLineService;

    @GetMapping
    public String createInvoiceLine(@ModelAttribute("invoice") Invoice invoice, Model model){
        List<InvoiceLine> invoiceLines = invoiceLineService.getInvoiceLinesByInvoice(invoice.getInvoiceNumber());
        model.addAttribute("invoiceLines", invoiceLines);
        model.addAttribute("invoiceLine", new InvoiceLine()); // objeto vacío para el modal
        model.addAttribute("showCreateInvoiceLineModal", true); // aquí activamos el modal
        return "inovices/form"; // misma plantilla con modal abierto
    }
}
