package ru.sermyazhko.SpringSecurityTestTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.AccountOwner;

public interface AccountOwnerRepository extends JpaRepository<AccountOwner, Long> {
}
