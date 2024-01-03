package com.chadmiddleton.dynastyx.account;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Username is required")
    private String username;
//    private String firstName;
//    private String lastName;
    @Email(message = "Email should be valid")
    @NotNull(message = "Email is required")
    @Column(unique = true)
    private String email;
    @Size(min = 12, message = "Password must be more than 12 characters")
    private String password;
}

