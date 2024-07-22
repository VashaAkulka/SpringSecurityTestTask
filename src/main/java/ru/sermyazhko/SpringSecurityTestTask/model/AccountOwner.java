package ru.sermyazhko.SpringSecurityTestTask.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.Role;

@Data
@Entity
@DiscriminatorValue("ACCOUNT_OWNER")
public class AccountOwner extends User {
    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Account account;


    @Override
    public Role getRole() {
        return Role.ACCOUNT_OWNER;
    }
}
