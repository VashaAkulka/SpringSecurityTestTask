package ru.sermyazhko.SpringSecurityTestTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.sermyazhko.SpringSecurityTestTask.service.AccountService;

@Controller
@AllArgsConstructor
public class AdminController {
    private final AccountService accountService;

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "dashboard";
    }

    @PutMapping("/admin/blockAccount/{id}")
    public String block(@PathVariable("id") Long id) {
        accountService.blockAccount(id);
        return "redirect:/admin/dashboard";
    }
}
