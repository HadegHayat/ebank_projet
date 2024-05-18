package ma.emsi.ebankingbackend.services;


import ma.emsi.ebankingbackend.dtos.*;
import ma.emsi.ebankingbackend.exceptions.BalanceNotSufficientException;
import ma.emsi.ebankingbackend.exceptions.BankAcountNotFoundException;
import ma.emsi.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;
public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAcountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAcountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAcountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAcountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAcountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}

