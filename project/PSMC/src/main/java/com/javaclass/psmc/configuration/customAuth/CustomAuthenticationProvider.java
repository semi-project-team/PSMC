package com.javaclass.psmc.configuration.customAuth;

import com.javaclass.psmc.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        String pmCode = ((MyCustomAuthenticationToken) authentication).getPmCode();

        LoginUserDTO loginUserDTO = userService.findByUsername(username);
        return null;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
