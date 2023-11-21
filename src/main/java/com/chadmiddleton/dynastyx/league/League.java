package com.chadmiddleton.dynastyx.league;

import com.chadmiddleton.dynastyx.account.Account;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name = "Dynasty League";
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
