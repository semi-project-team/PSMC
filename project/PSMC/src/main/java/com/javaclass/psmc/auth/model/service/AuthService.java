package com.javaclass.psmc.auth.model.service;

import com.javaclass.psmc.auth.model.AuthDetails;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    private final UserService userService;
    @Autowired
    public AuthService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUserDTO loginUserDTO = userService.findByUsername(username);
        if(Objects.isNull(loginUserDTO)){
            throw new UsernameNotFoundException("해당하는 유저는 존재하지 않습니다");
        }
        System.out.println(loginUserDTO);
        return new AuthDetails(loginUserDTO);


    }
}
