package com.tallertornofumero.erp.erp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "invoiceLines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceLine {

    @Id
    private String invoiceLineId;
    private Integer invoiceLineNumber;
    private String description;
    private String price;

    @DBRef
    private Invoice invoice;

}
