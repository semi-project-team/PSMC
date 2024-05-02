package com.javaclass.psmc.auth.model;

import com.javaclass.psmc.user.model.dto.SignUpDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AuthDetails implements UserDetails {

    private SignUpDTO loginUserDTO;
    public AuthDetails(){}
    public AuthDetails(SignUpDTO loginUserDTO){
        this.loginUserDTO=loginUserDTO;
    }

    public SignUpDTO getLoginUserDTO() {
        return loginUserDTO;
    }

    public void setLoginUserDTO(SignUpDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
