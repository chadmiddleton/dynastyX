package com.chadmiddleton.dynastyx.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
class AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    public Account createAccount(Account account) throws DataIntegrityViolationException {
        return accountRepository.save(account);
    }

    public Iterable<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountByEmail(String email) {
        return accountRepository.getByEmail(email);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
