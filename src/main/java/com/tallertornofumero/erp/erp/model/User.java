package com.tallertornofumero.erp.erp.model;

import com.tallertornofumero.erp.erp.enums.UserRoles;
import com.tallertornofumero.erp.erp.enums.UserStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;
    private String email;
    private UserStatus status;
    private UserRoles rol;
}
