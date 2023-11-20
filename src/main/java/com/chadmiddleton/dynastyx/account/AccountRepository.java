package com.chadmiddleton.dynastyx.account;

import com.chadmiddleton.dynastyx.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    Account getByEmail(String email);
}
