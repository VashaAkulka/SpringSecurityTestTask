package ru.sermyazhko.SpringSecurityTestTask.model;

import org.springframework.security.core.GrantedAuthority;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.Role;

public interface RoleProvider extends GrantedAuthority {
    Role getRole();

    @Override
    default String getAuthority() {
        return getRole().name();
    }
}
