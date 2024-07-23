package ru.sermyazhko.SpringSecurityTestTask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Account;
import ru.sermyazhko.SpringSecurityTestTask.repository.AccountRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getOwnerAccount(Long ownerId) {
        return accountRepository.findByOwner_Id(ownerId);
    }

    public void blockAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(RuntimeException::new);
        account.setIsBlocked(!account.getIsBlocked());
        accountRepository.save(account);
    }
}
