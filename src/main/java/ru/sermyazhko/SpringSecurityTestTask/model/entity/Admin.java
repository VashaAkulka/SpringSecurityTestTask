package ru.sermyazhko.SpringSecurityTestTask.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import ru.sermyazhko.SpringSecurityTestTask.model.User;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.Role;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(Role.ADMIN);
    }
}
