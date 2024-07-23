package ru.sermyazhko.SpringSecurityTestTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
