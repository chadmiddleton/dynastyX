package com.chadmiddleton.dynastyx.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${base.path}/account")
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value="/ui")
    public String index(){
        return "index";
    }
    @PostMapping
    public @ResponseBody ResponseEntity<Account> createAccount(@RequestBody Account account) {
        try {
            return ResponseEntity.ok(accountService.createAccount(account));
        } catch (DataIntegrityViolationException e) {
            throw new ACException(e.getMessage());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Iterable<Account>> getAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping(value = "/{email}")
    public @ResponseBody ResponseEntity<Account> getAccountByEmail(@PathVariable String email) {
        return ResponseEntity.ok(accountService.getAccountByEmail(email));
    }

    @PutMapping
    public @ResponseBody ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.updateAccount(account));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @ExceptionHandler(ACException.class)
    public ResponseEntity<ACErrorResponse> handleACException(ACException acException) {
        ACErrorResponse acErrorResponse = new ACErrorResponse(HttpStatus.BAD_REQUEST
                , acException.getMessage());
        return new ResponseEntity<>(acErrorResponse, HttpStatus.BAD_REQUEST);
    }

    // Custom exception class
    static class ACException extends RuntimeException {
        public ACException(String message) {
            super(message);
        }
    }

    // Custom error response class
    record ACErrorResponse(HttpStatus status, String message) {
    }
}
