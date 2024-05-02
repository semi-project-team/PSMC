package com.javaclass.psmc.auth.model.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final String pmCode;

    public CustomAuthenticationToken(String principal,String credentials, String pmCode){
        super(principal,credentials);
        this.pmCode = pmCode;
    }

    public String getPmCode(){
        return this.pmCode;
    }
}
