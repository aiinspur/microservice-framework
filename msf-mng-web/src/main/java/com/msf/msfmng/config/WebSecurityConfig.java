package com.msf.msfmng.config;

import com.msf.msfmng.security.LoginSuccessHandler;
import com.msf.msfmng.security.SysAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author shihujiang
 * @date 2019-06-12
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);


    public WebSecurityConfig(SysAuthenticationProvider sysAuthenticationProvider,
                             LoginSuccessHandler loginSuccessHandler) {
        this.sysAuthenticationProvider = sysAuthenticationProvider;
        this.loginSuccessHandler = loginSuccessHandler;
        log.debug("WebSecurityConfig...");
    }


    private SysAuthenticationProvider sysAuthenticationProvider;

    private LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers("/shared/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/","/signup.html","/signin.html","/locale","/favicon.ico","/s/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403.html")
                    .and()
                .formLogin()
                    .loginPage("/signin.html").permitAll()
                    .loginProcessingUrl("/signin.html")
                    .defaultSuccessUrl("/index.html")
                    .failureUrl("/login-error.html")
                    .successHandler(loginSuccessHandler)
                    .and()
                .logout()
                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/index.html")
        ;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder builder) {
        builder.authenticationProvider(sysAuthenticationProvider);
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/ace/**","/s/**","/webjars/**");
    }
}
