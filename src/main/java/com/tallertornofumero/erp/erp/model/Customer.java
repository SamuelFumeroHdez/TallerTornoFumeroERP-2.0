package com.tallertornofumero.erp.erp.model;

import com.tallertornofumero.erp.erp.enums.CustomerStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    private String customerId;
    private String legalName;
    private String name;
    private String nif;
    private String address;
    private String phoneNumber;
    private String email;
    private CustomerStatus status;

}
