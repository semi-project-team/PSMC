package com.javaclass.psmc.auth.model;

import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.dto.SignupDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthDetails implements UserDetails {

    private LoginUserDTO loginUserDTO;
    public AuthDetails(){}
    public AuthDetails(LoginUserDTO loginUserDTO){
        this.loginUserDTO=loginUserDTO;
    }

    public LoginUserDTO getLoginUserDTO() {
        return loginUserDTO;
    }

    public void setLoginUserDTO(LoginUserDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }

    /*다중권한 용*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        loginUserDTO.getRole().forEach(role->authorities.add(()->role));
        return authorities;
    }

    @Override
    public String getPassword() {

        return loginUserDTO.getPassword();
    }

    @Override
    public String getUsername() {

        return loginUserDTO.getId();
    }

    // 만기 여부를 결정 false 면 해당 개정 사용불가
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 반복 비밀번호 오류 또는 사용기간 이 오래 되어 휴면 상태
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 탈퇴여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }
}
