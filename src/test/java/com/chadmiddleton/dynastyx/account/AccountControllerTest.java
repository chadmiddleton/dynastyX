package com.chadmiddleton.dynastyx.account;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Mock AccountService accountService;
    AccountController accountController;
    Account account;
    @BeforeEach
    void init(@Mock AccountService accountService){
        accountController = new AccountController(accountService);

//        when(accountService.createAccount(eq(account))).thenReturn(account);
    }
//    @BeforeEach
//    void init(@Mock SettingRepository settingRepository) {
//        userService = new DefaultUserService(userRepository, settingRepository, mailClient);
//
//        lenient().when(settingRepository.getUserMinAge()).thenReturn(10);
//
//        when(settingRepository.getUserNameMinLength()).thenReturn(4);
//
//        lenient().when(userRepository.isUsernameAlreadyExists(any(String.class)))
//                .thenReturn(false);
//    }
    @Test
    void createAccount(){
        //Given
        Account account = Account.builder().lastName("Winchester").build();
        accountController = new AccountController(accountService);
        //When
        ResponseEntity<Account> result = accountController.createAccount(account);
        //Then
        verify(accountService).createAccount(account);
//        assertNotNull(result.getBody().getId());
    }
}
