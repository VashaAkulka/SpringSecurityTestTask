package ru.sermyazhko.SpringSecurityTestTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.sermyazhko.SpringSecurityTestTask.model.User;
import ru.sermyazhko.SpringSecurityTestTask.service.AccountService;

@Controller
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/account/{ownerId}")
    public String home(@PathVariable("ownerId") Long ownerId, Model model,
                       Authentication authentication) {
        User user = (User)authentication.getPrincipal();
        if (!user.getId().equals(ownerId)) return "error";

        model.addAttribute("account", accountService.getOwnerAccount(ownerId));
        return "account";
    }
}
