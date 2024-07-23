package ru.sermyazhko.SpringSecurityTestTask.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sermyazhko.SpringSecurityTestTask.exception.UserAlreadyExistsException;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Account;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.AccountOwner;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Admin;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.Role;
import ru.sermyazhko.SpringSecurityTestTask.repository.AccountOwnerRepository;
import ru.sermyazhko.SpringSecurityTestTask.repository.AdminRepository;
import ru.sermyazhko.SpringSecurityTestTask.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AccountOwnerRepository accountOwnerRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("not found user")
        );
    }

    public void addUser(String username, String password, Role role) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UserAlreadyExistsException("Пользователь с таким ником уже есть");
        }

        if (role == Role.ACCOUNT_OWNER) {
            AccountOwner accountOwner = new AccountOwner();
            accountOwner.setUsername(username);
            accountOwner.setPassword(passwordEncoder.encode(password));

            Account account = new Account();
            account.setOwner(accountOwner);
            accountOwner.setAccount(account);

            accountOwnerRepository.save(accountOwner);
        } else if (role == Role.ADMIN) {
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(passwordEncoder.encode(password));

            adminRepository.save(admin);
        }
    }
}
