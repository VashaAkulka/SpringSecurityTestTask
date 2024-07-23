package ru.sermyazhko.SpringSecurityTestTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.sermyazhko.SpringSecurityTestTask.exception.PasswordMismatchException;
import ru.sermyazhko.SpringSecurityTestTask.exception.UserAlreadyExistsException;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.Role;
import ru.sermyazhko.SpringSecurityTestTask.service.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword,
                               @RequestParam("role") Role role,
                               RedirectAttributes redirectAttributes) {
        try {
            if (!password.equals(confirmPassword)) throw new PasswordMismatchException("Пароли не совпадают");
            userService.addUser(username, password, role);
        } catch (UserAlreadyExistsException | PasswordMismatchException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/registration";
        }

        return "redirect:/login";
    }
}
