package ru.itis.nishesi.microservices.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ApikeyAuthenticationToken extends AbstractAuthenticationToken {
    private final String apikey;

    public ApikeyAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String apikey) {
        super(authorities);
        this.apikey = apikey;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return apikey;
    }
}
