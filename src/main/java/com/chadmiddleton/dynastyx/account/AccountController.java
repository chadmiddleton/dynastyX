package com.chadmiddleton.dynastyx.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${base.path}/account")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Account> createAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  ResponseEntity<Iterable<Account>> getAccounts(){
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping(value = "/{email}")
    public @ResponseBody ResponseEntity<Account> getAccountByEmail(@PathVariable String email){
        return ResponseEntity.ok(accountService.getAccountByEmail(email));
    }

    @PutMapping
    public @ResponseBody ResponseEntity<Account> updateAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.updateAccount(account));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
}
