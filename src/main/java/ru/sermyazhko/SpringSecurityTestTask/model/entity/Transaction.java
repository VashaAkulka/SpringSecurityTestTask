package ru.sermyazhko.SpringSecurityTestTask.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.TransactionType;

import java.math.BigDecimal;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
