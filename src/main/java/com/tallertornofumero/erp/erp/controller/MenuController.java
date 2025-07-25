package com.tallertornofumero.erp.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MenuController {

    @GetMapping("/")
    public String showMainMenu(){
        return "menu";
    }
}
