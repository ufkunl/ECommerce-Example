package com.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Authentication : User --> Roles
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
                .withUser("user").password("userPass").roles("USER")
                .and()
                .withUser("admin").password("adminPass").roles("USER", "ADMIN");
    }

    // Authorization : Role -> Access
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/product").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/product").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/product").hasRole("ADMIN")
                .antMatchers("/product/**").permitAll()
                .antMatchers("/category/**").permitAll()
                .and().csrf().disable().headers().frameOptions().disable();
    }

}
