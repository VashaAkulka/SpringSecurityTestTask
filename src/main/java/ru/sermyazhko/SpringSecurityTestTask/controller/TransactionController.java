package ru.sermyazhko.SpringSecurityTestTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.sermyazhko.SpringSecurityTestTask.exception.BadAmountException;
import ru.sermyazhko.SpringSecurityTestTask.exception.BlockAccountException;
import ru.sermyazhko.SpringSecurityTestTask.model.User;
import ru.sermyazhko.SpringSecurityTestTask.model.entity.Transaction;
import ru.sermyazhko.SpringSecurityTestTask.service.TransactionService;

@Controller
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PutMapping("/account/{ownerId}/transaction")
    public String transaction(@PathVariable("ownerId") Long ownerId,
                              @ModelAttribute Transaction transaction,
                              Authentication authentication,
                              RedirectAttributes redirectAttributes) {
        User user = (User)authentication.getPrincipal();
        if (!user.getId().equals(ownerId)) return "error";

        try {
            transactionService.makeTransaction(ownerId, transaction);
        } catch (BlockAccountException | BadAmountException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/account/" + ownerId;
    }
}
