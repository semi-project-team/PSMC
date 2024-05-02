package com.javaclass.psmc.configuration.customAuth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class MyCustomAuthenticationToken extends AbstractAuthenticationToken {
    private final String username;
    private final String password;
    private final String pmCode;
    public MyCustomAuthenticationToken(String username,String password, String pmCode) {
        super(null);
        this.username=username;
        this.password = password;
        this.pmCode=pmCode;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }
    public String getPmCode(){
        return pmCode;
    }
}
