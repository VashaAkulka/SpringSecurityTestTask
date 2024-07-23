package ru.sermyazhko.SpringSecurityTestTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccount_Owner_Id(Long id);
}
