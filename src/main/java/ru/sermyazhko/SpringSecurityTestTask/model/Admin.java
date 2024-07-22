package ru.sermyazhko.SpringSecurityTestTask.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.Role;

@Data
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }
}
