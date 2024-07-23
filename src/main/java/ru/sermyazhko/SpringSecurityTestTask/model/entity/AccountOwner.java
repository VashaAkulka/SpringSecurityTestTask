package ru.sermyazhko.SpringSecurityTestTask.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import ru.sermyazhko.SpringSecurityTestTask.model.User;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.Role;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@DiscriminatorValue("ACCOUNT_OWNER")
public class AccountOwner extends User {
    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Account account;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(Role.ACCOUNT_OWNER);
    }
}
