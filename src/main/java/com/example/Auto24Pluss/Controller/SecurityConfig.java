package com.example.Auto24Pluss.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Object AuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers( "/createaccount.html","/createaccount","/manifest.json", "/style.css", "/Images/Logo.png", "/docs/4.5/assets/img/favicons/android-chrome-192x192.png").permitAll() //nii saan kirjeldada, et kõigil on ligipääs esilehele
                .anyRequest().authenticated() //kui tahan, et parooli ei küsiks, siis panen .permitAll/.authenticated
                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                 //             .successForwardUrl("/loggedin.html")
                 //             .successHandler((org.springframework.security.web.authentication.AuthenticationSuccessHandler) AuthenticationSuccessHandler)
                .defaultSuccessUrl("/loggedin.html")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
        http.csrf().disable();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
