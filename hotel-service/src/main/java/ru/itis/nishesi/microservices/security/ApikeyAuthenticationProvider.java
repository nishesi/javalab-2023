package ru.itis.nishesi.microservices.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApikeyAuthenticationProvider implements AuthenticationProvider {

    @Value("${app.api.authentication.key}")
    private String apikey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!authentication.getPrincipal().equals(apikey))
            throw new BadCredentialsException("Invalid API KEY");

        return new UsernamePasswordAuthenticationToken(apikey, null,
                List.of(new SimpleGrantedAuthority("TRUSTED_SERVICE")));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApikeyAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
