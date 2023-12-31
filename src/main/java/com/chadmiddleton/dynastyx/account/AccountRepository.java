package com.chadmiddleton.dynastyx.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AccountRepository extends JpaRepository<Account, Long> {
    Account getByEmail(String email);
}
