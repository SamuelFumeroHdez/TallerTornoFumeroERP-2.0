package com.tallertornofumero.erp.erp.controller;

import com.tallertornofumero.erp.erp.exception.CustomerAlreadyExistsException;
import com.tallertornofumero.erp.erp.model.Customer;
import com.tallertornofumero.erp.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "customers/list"; // Se renderiza customers/list.html
    }

    @GetMapping("/customers/new")
    public String newCustomer(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer()); // objeto vacío para el modal
        model.addAttribute("showCreateModal", true); // aquí activamos el modal
        return "customers/list"; // misma plantilla con modal abierto
    }

    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model, RedirectAttributes redirectAttributes) {
        try{
            customerService.createCustomer(customer);
            redirectAttributes.addFlashAttribute("succesMessage", "Cliente creado correctamente.");
            return "redirect:/customers";
        }catch (CustomerAlreadyExistsException ex){
            model.addAttribute("customer", customer);
            model.addAttribute("showCreateModal", true);
            model.addAttribute("errorMessage", ex.getMessage());
            return "customers/list";
        }


    }

    @PostMapping("/customers/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer.getNif(), customer);
        return "redirect:/customers";
    }


    @GetMapping("/customers/details/{nif}")
    public String viewCustomer(@PathVariable String nif, Model model){
        List<Customer> customers = customerService.getAllCustomers();
        Customer customer = customerService.getCustomerByNif(nif);
        model.addAttribute("customers", customers);
        model.addAttribute("customer", customer);
        model.addAttribute("showCustomerDetailsModal", true);
        return "customers/list";

    }

    @GetMapping("/customers/delete/{nif}")
    public String deleteCustomer(@PathVariable String nif, Model model){
        customerService.deleteCustomer(nif);
        return "redirect:/customers";
    }



}
