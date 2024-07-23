package ru.sermyazhko.SpringSecurityTestTask.model.enums;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    ACCOUNT_OWNER;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
