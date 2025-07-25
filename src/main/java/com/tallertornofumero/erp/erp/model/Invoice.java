package com.tallertornofumero.erp.erp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    private String Id;
    private Integer invoiceNumber;
    private Date invoiceDate;
    private Double subtotal;
    private boolean hasTax;
    private Double taxPercent;
    private Double totalTax;
    private Double total;

    @DBRef
    private Customer customer;
}
