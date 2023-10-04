package ru.itis.nishesi.microservices.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApikeyAuthenticationFilter extends OncePerRequestFilter {
    private static final String API_KEY_PARAMETER_NAME = "api-key";
    private final AuthenticationManager authenticationManager;

    protected ApikeyAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        String apiKey = request.getParameter(API_KEY_PARAMETER_NAME);

        if (apiKey != null) SecurityContextHolder.getContext().setAuthentication(
                authenticationManager.authenticate(new ApikeyAuthenticationToken(AuthorityUtils.NO_AUTHORITIES, apiKey))
        );
        filterChain.doFilter(request, response);
    }
}
