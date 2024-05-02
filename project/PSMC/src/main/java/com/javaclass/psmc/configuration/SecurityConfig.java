package com.javaclass.psmc.configuration;

import com.javaclass.psmc.common.UserRole;
import com.javaclass.psmc.configuration.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder() ;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web->web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                /*static 폴더 하위에 assets 파일또한 제외 시키기 위한 방법*/
                .requestMatchers(new AntPathRequestMatcher("/assets/**"))
                .requestMatchers(new AntPathRequestMatcher("/common/**"));

    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth->{

            auth.requestMatchers("/auth/login","/user/signup","/auth/fail","/member/*","auth/takeCode","/","/main").permitAll();

            auth.requestMatchers("/doc/*").hasAnyAuthority(UserRole.DOCTOR.getRole());
            auth.requestMatchers("/thera/*").hasAnyAuthority(UserRole.THERAPY.getRole());



            // 로그인 한사람은 누구나 접근가능한 url을 여기다 적어주세요
            auth.anyRequest().authenticated();
        }).formLogin(login->{
            login.loginPage("/auth/login");
            login.usernameParameter("user");
            login.passwordParameter("pass");

            // 로그인 성공시 보낼 url 을 적어주세요
            login.defaultSuccessUrl("/",true);

            // 로그인 실패시
            login.failureHandler(authFailHandler);
        }).logout(logout->{
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"));
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            logout.logoutSuccessUrl("/");
        }).sessionManagement(session->{
            session.maximumSessions(1);
            session.invalidSessionUrl("/");
        }).csrf(csrf->csrf.disable());


        return httpSecurity.build();

    }

}
