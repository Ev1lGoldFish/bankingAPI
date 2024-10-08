package dev.harsha.bankingApp.service.impl;

import dev.harsha.bankingApp.dto.AccountDto;
import dev.harsha.bankingApp.entity.Account;
import dev.harsha.bankingApp.mapper.AccountMapper;
import dev.harsha.bankingApp.repository.AccountRepository;
import dev.harsha.bankingApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).
                orElseThrow(( ) -> new RuntimeException("Account doesn't exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.
                findById(id).
                orElseThrow(( ) -> new RuntimeException("Account doesn't exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.
                findById(id).
                orElseThrow(( ) -> new RuntimeException("Account doesn't exist"));
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient funds");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.
                findById(id).
                orElseThrow(( ) -> new RuntimeException("Account doesn't exist"));

        accountRepository.deleteById(id);
    }


}
