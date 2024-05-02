package com.javaclass.psmc.configuration.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;
import java.net.URLEncoder;

@Configuration
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage ="";
        if(exception instanceof UsernameNotFoundException) {
            errorMessage = "존재하지 않는 아이디 입니다. 아이디를 확인하세요";
        }
        else if(exception instanceof InternalAuthenticationServiceException) {
            errorMessage = "서버에 오류가 발생하였습니다. 관리자에게 문의해주세요";
        }
        else if(exception instanceof AuthenticationCredentialsNotFoundException){
            errorMessage="인증요청이 거부 되었습니다";
        }else if(exception instanceof BadCredentialsException){
            errorMessage="비밀번호가 일치하지 않습니다. 비밀번호를 확인하세요";
        }else{
            errorMessage="알수없는 오류로 로그인 요청을 처리 할 수 없습니다";
        }


        errorMessage = URLEncoder.encode("/auth/fail?message="+errorMessage);
        super.onAuthenticationFailure(request, response, exception);
    }
}
