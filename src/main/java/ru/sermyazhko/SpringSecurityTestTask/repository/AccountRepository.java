package ru.sermyazhko.SpringSecurityTestTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByOwner_Id(Long id);
}
