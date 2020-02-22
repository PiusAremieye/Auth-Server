package com.authserver.pius.configurer;

import com.authserver.pius.service.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableAuthorizationServer
class AuthServiceConfig extends AuthorizationServer {

    private AuthUserDetailsService authUserDetailsService;

    @Autowired
    public AuthServiceConfig(AuthUserDetailsService authUserDetailsService){
        this.authUserDetailsService = authUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(authUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signup").permitAll()
                .anyRequest().authenticated();
//                .and().formLogin()
//                .loginPage("/login").permitAll(true)
//                .and().logout().permitAll();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()throws  Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
