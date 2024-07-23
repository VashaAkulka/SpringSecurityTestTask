package ru.sermyazhko.SpringSecurityTestTask.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.sermyazhko.SpringSecurityTestTask.model.User;
import ru.sermyazhko.SpringSecurityTestTask.model.enums.Role;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User)authentication.getPrincipal();

        if (authentication.getAuthorities().contains(Role.ACCOUNT_OWNER)) {
            response.sendRedirect("account/" + user.getId());
        } else if (authentication.getAuthorities().contains(Role.ADMIN)) {
            response.sendRedirect("admin/dashboard");
        }
    }
}
