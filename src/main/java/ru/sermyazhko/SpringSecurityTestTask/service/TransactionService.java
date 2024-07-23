package ru.sermyazhko.SpringSecurityTestTask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sermyazhko.SpringSecurityTestTask.exception.BadAmountException;
import ru.sermyazhko.SpringSecurityTestTask.exception.BlockAccountException;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Account;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Transaction;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.TransactionType;
import ru.sermyazhko.SpringSecurityTestTask.repository.AccountRepository;
import ru.sermyazhko.SpringSecurityTestTask.repository.TransactionRepository;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public void makeTransaction(Long id, Transaction transaction) throws BlockAccountException, BadAmountException {
        if (transaction.getAmount() == null || transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) throw new BadAmountException("Некорректная сумма");

        Account account = accountRepository.findByOwner_Id(id);

        if (!account.getIsBlocked()) {
            if (transaction.getType() == TransactionType.DEPOSIT) {
                account.setBalance(account.getBalance().add(transaction.getAmount()));
            } else if (transaction.getType() == TransactionType.WITHDRAWAL) {
                if (account.getBalance().compareTo(transaction.getAmount()) >= 0) {
                    account.setBalance(account.getBalance().subtract(transaction.getAmount()));
                } else throw new BadAmountException("Некорректная сумма");
            }

            transaction.setAccount(account);
            account.getTransactions().add(transaction);
            transactionRepository.save(transaction);
            accountRepository.save(account);
        } else {
            throw new BlockAccountException("Аккаунт заблокирован");
        }
    }
}
